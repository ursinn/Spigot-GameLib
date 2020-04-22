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

package dev.ursinn.spigot.gamelib.helpers;

import dev.ursinn.java.databaselib.sql.SQL;
import dev.ursinn.spigot.gamelib.enums.GameCoinsEnum;
import org.bukkit.plugin.Plugin;

/**
 * Helper - Options
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GameOptionsHelper {

    private final Plugin plugin;

    /**
     * Constructor
     *
     * @param plugin Plugin instance
     * @since 1.0
     */
    public GameOptionsHelper(Plugin plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
    }

    /**
     * Get ServerId
     *
     * @return the Server Id
     * @since 1.0
     */
    public String getServerId() {
        return plugin.getConfig().getString("server.id");
    }

    /**
     * Get Game name
     *
     * @return Game name
     * @since 1.0
     */
    public String getGame() {
        return plugin.getConfig().getString("game.name");
    }

    /**
     * Is Server Mode
     *
     * @return Server Mode
     * @since 1.0
     */
    public boolean isServerMode() {
        return plugin.getConfig().getBoolean("server.mode");
    }

    /**
     * Get Database Prefix
     *
     * @return Database Prefix
     * @since 1.0
     */
    public String getDatabasePrefix() {
        return plugin.getConfig().getString("database.prefix");
    }

    /**
     * Get SQL Based Database
     *
     * @return SQL Database
     * @since 1.0
     */
    public SQL getDatabase() {
        return null;
    }

    /**
     * Get GameCoinsEnum
     *
     * @return GameCoinsEnum
     * @since 1.0
     */
    public GameCoinsEnum getGameCoinsEnum() {
        return GameCoinsEnum.NONE;
    }

    /**
     * Is Metrics Allowed
     *
     * @return Metrics allowed
     * @since 1.0
     */
    public boolean useMetrics() {
        return plugin.getConfig().getBoolean("settings.metrics");
    }

    /**
     * Is Update Check allowed
     *
     * @return Update Check allowed
     * @since 1.0
     */
    public boolean useUpdateChecker() {
        return plugin.getConfig().getBoolean("settings.update");
    }

    /**
     * Is in Setup Mode
     *
     * @return setup status
     * @since 1.0
     */
    public boolean isSetup() {
        return plugin.getConfig().getBoolean("settings.setup");
    }
}
