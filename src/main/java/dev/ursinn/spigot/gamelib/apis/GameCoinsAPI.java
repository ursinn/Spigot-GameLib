/*
 * MIT License
 *
 * Copyright (c) 2020 Ursin Filli
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package dev.ursinn.spigot.gamelib.apis;

import dev.ursinn.java.databaselib.sql.SQL;
import dev.ursinn.spigot.gamelib.enums.GameCoinsEnum;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * API - Coins API
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GameCoinsAPI {

    private final SQL db;
    private final String table;
    private final GameCoinsEnum coinsEnum;

    private Economy economy;

    /**
     * Constructor
     *
     * @param prefix    Table Prefix or null
     * @param db        Database
     * @param coinsEnum Coins Enum
     * @since 1.0
     */
    public GameCoinsAPI(String prefix, SQL db, GameCoinsEnum coinsEnum) {
        this.db = db;
        this.coinsEnum = coinsEnum;
        if (prefix != null)
            this.table = prefix + "_coins";
        else
            this.table = "coins";
        if (coinsEnum == GameCoinsEnum.VAULT)
            setupVault();
    }

    /**
     * Init Database
     *
     * @since 1.0
     */
    public void init() {
        if (coinsEnum == GameCoinsEnum.OUR) {
            try {
                db.update("CREATE TABLE IF NOT EXISTS `" + table + "` (" +
                        " `id` INT NOT NULL AUTO_INCREMENT ," +
                        " `uuid` VARCHAR(255) NOT NULL ," +
                        " `coins` INT NOT NULL DEFAULT '0' ," +
                        " PRIMARY KEY (`id`)) ENGINE = InnoDB; ");
            } catch (SQLException e) {
                System.err.println("GameLib.GameCoinsAPI.initStats:" + e.getMessage());
            }
        }
    }

    /**
     * Init Player
     *
     * @param uuid Player UUID
     * @since 1.0
     */
    private void initPlayer(String uuid) {
        if (coinsEnum == GameCoinsEnum.OUR) {
            try {
                db.update("INSERT INTO `" + table + "` (`uuid`) VALUES ('" + uuid + "');");
            } catch (SQLException e) {
                System.err.println("GameLib.GameCoinsAPI.initPlayer:" + e.getMessage());
            }
        }
    }

    /**
     * Give Player Coins
     *
     * @param uuid Player UUID
     * @param value Coins
     * @since 1.0
     */
    public void giveCoins(String uuid, int value) {
        initPlayer(uuid);
        if (coinsEnum == GameCoinsEnum.OUR) {
            int coins = getCoins(uuid) + value;
            setCoins(uuid, coins);
        }
        if (coinsEnum == GameCoinsEnum.VAULT) {
            economy.depositPlayer(Bukkit.getOfflinePlayer(UUID.fromString(uuid)), value);
        }
    }

    /**
     * Set Player Coins
     *
     * @param uuid  Player UUID
     * @param value Coins
     * @since 1.0
     */
    public void setCoins(String uuid, int value) {
        initPlayer(uuid);
        if (coinsEnum == GameCoinsEnum.OUR) {
            try {
                db.update("UPDATE `" + table + "` SET `coins`='" + value + "' WHERE `uuid` = '" + uuid + "'");
            } catch (SQLException e) {
                System.err.println("GameLib.GameCoinsAPI.setCoins:" + e.getMessage());
            }
        }
    }

    /**
     * Take Player Coins
     *
     * @param uuid  Player UUID
     * @param value Coins
     * @return true if player had enough coins
     * @since 1.0
     */
    public boolean takeCoins(String uuid, int value) {
        if (coinsEnum == GameCoinsEnum.OUR) {
            int coins = getCoins(uuid) - value;
            if (coins < 0)
                return false;
            setCoins(uuid, coins);
            return true;
        }
        if (coinsEnum == GameCoinsEnum.VAULT) {
            EconomyResponse response = economy.withdrawPlayer(Bukkit.getOfflinePlayer(UUID.fromString(uuid)), value);
            return response.transactionSuccess();
        }
        return false;
    }

    /**
     * Get Player Coins
     *
     * @param uuid Player UUID
     * @return 0 or Player Coins
     * @since 1.0
     */
    public int getCoins(String uuid) {
        if (coinsEnum == GameCoinsEnum.OUR) {
            try {
                ResultSet rs = db.getResult("SELECT `coins` FROM `" + table + "` WHERE `uuid` = '" + uuid + "'");
                if (rs.next())
                    return rs.getInt("coins");
            } catch (SQLException e) {
                System.err.println("GameLib.GameCoinsAPI.getCoins:" + e.getMessage());
            }
        }
        if (coinsEnum == GameCoinsEnum.VAULT) {
            return (int) economy.getBalance(Bukkit.getOfflinePlayer(UUID.fromString(uuid)));
        }
        return 0;
    }

    private void setupVault() {
        if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null)
            return;
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null)
            return;
        economy = rsp.getProvider();
    }

}
