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

package dev.ursinn.spigot.gamelib.api;

import dev.ursinn.java.databaselib.sql.MySQL;
import dev.ursinn.spigot.gamelib.enums.GameStatsEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameStatsAPI {

    private MySQL mySQL;
    private String table;

    GameStatsAPI(String game, String prefix, MySQL mySQL) {
        this.mySQL = mySQL;
        if (prefix != null)
            this.table = prefix + "_" + game + "_stats";
        else
            this.table = game + "_stats";
    }

    public void initStats(ArrayList<GameStatsEnum> statsEnums) {
        if (statsEnums == null)
            return;

        boolean exists = false;

        try {
            mySQL.update("CREATE TABLE IF NOT EXISTS `" + table + "` (" +
                    "  `id` int(11) NOT NULL," +
                    "  `uuid` varchar(255) NOT NULL" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");
        } catch (SQLException e) {
            exists = true;
        }

        if (!exists) {
            try {
                mySQL.update("ALTER TABLE `" + table + "`" +
                        "  ADD PRIMARY KEY (`id`)," +
                        "  ADD UNIQUE KEY `uuid` (`uuid`);");
                mySQL.update("ALTER TABLE `" + table + "`" +
                        "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;" +
                        "COMMIT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        statsEnums.forEach(statsEnum -> {
            if (statsEnum.getId() != 0)
                addStats(statsEnum);
        });
    }

    private void addStats(GameStatsEnum statsEnum) {
        try {
            mySQL.update("ALTER TABLE `" + table + "` ADD `stats_" + statsEnum.getId() + "` INT NOT NULL;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStats(String uuid, GameStatsEnum statsEnum, int value) {
        try {
            mySQL.update("UPDATE `" + table + "` SET `stats_" + statsEnum.getId() + "`='" + value + "' WHERE `uuid` = '" + uuid + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getStats(String uuid, GameStatsEnum statsEnum) {
        try {
            ResultSet rs = mySQL.getResult("SELECT `stats_" + statsEnum.getId() + "` FROM `" + table + "` WHERE `uuid` = '" + uuid + "'");
            if (rs.next())
                return rs.getInt("stats_" + statsEnum.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
