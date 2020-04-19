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

import dev.ursinn.java.databaselib.sql.SqlDatabase;
import dev.ursinn.spigot.gamelib.enums.GameStatsEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * API - Stats API
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GameStatsAPI {

    private final SqlDatabase db;
    private final String table;

    /**
     * Constructor
     *
     * @param game   Game
     * @param prefix Table Prefix or null
     * @param db     Database
     */
    public GameStatsAPI(String game, String prefix, SqlDatabase db) {
        this.db = db;
        if (prefix != null)
            this.table = prefix + "_" + game + "_stats";
        else
            this.table = game + "_stats";
    }

    /**
     * Init Database
     *
     * @param statsEnums Arraylist with Stats Enums
     * @since 1.0
     */
    public void init(ArrayList<GameStatsEnum> statsEnums) {
        try {
            db.update("CREATE TABLE IF NOT EXISTS `" + table + "` (" +
                    " `id` INT NOT NULL AUTO_INCREMENT ," +
                    " `uuid` VARCHAR(255) NOT NULL ," +
                    " PRIMARY KEY (`id`)) ENGINE = InnoDB; ");
        } catch (SQLException e) {
            System.err.println("GameLib.GameStatsAPI.initStats:" + e.getMessage());
        }

        if (statsEnums == null)
            return;

        statsEnums.forEach(statsEnum -> {
            if (statsEnum.getId() != 0)
                addStats(statsEnum);
        });
    }

    /**
     * Add Stats to Database
     *
     * @param statsEnum Stats Enum
     * @since 1.0
     */
    private void addStats(GameStatsEnum statsEnum) {
        try {
            db.update("ALTER TABLE `" + table + "` ADD `stats_" + statsEnum.getId() + "` INT NOT NULL DEFAULT '0';");
        } catch (SQLException e) {
            System.err.println("GameLib.GameStatsAPI.addStats:" + e.getMessage());
        }
    }

    /**
     * Init Player
     *
     * @param uuid Player UUID
     * @since 1.0
     */
    private void initPlayer(String uuid) {
        try {
            db.update("INSERT INTO `" + table + "` (`uuid`) VALUES ('" + uuid + "');");
        } catch (SQLException e) {
            System.err.println("GameLib.GameStatsAPI.initPlayer:" + e.getMessage());
        }
    }

    /**
     * Update Stats
     *
     * @param uuid      Player UUID
     * @param statsEnum Stats Enum
     * @param value     Value
     * @since 1.0
     */
    public void updateStats(String uuid, GameStatsEnum statsEnum, int value) {
        initPlayer(uuid);
        try {
            db.update("UPDATE `" + table + "` SET `stats_" + statsEnum.getId() + "`='" + value + "' WHERE `uuid` = '" + uuid + "'");
        } catch (SQLException e) {
            System.err.println("GameLib.GameStatsAPI.updateStats:" + e.getMessage());
        }
    }

    /**
     * Get Stats
     *
     * @param uuid Player UUID
     * @param statsEnum Stats Enum
     * @return Value
     * @since 1.0
     */
    public int getStats(String uuid, GameStatsEnum statsEnum) {
        try {
            ResultSet rs = db.getResult("SELECT `stats_" + statsEnum.getId() + "` FROM `" + table + "` WHERE `uuid` = '" + uuid + "'");
            if (rs.next())
                return rs.getInt("stats_" + statsEnum.getId());
        } catch (SQLException e) {
            System.err.println("GameLib.GameStatsAPI.getStats:" + e.getMessage());
        }
        return 0;
    }

    /**
     * Get Top Players
     * @param top Top amount
     * @param statsEnum Stats Enum
     * @since 1.0
     */
    public void getTopPlayers(int top, GameStatsEnum statsEnum) {
        // TODO
    }

}
