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
import dev.ursinn.spigot.gamelib.enums.GameCoinsEnum;

import java.sql.SQLException;

public class GameCoinsAPI {

    private MySQL mySQL;
    private String table;
    private GameCoinsEnum coinsEnum;

    GameCoinsAPI(String prefix, MySQL mySQL, GameCoinsEnum coinsEnum) {
        this.mySQL = mySQL;
        this.coinsEnum = coinsEnum;
        if (prefix != null)
            this.table = prefix + "_coins";
        else
            this.table = "coins";
    }

    public void initStats() {
        if (coinsEnum == GameCoinsEnum.OUR) {
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
        }
    }

    public void giveCoins() {
        if (coinsEnum == GameCoinsEnum.OUR) {
            //
        }
    }

    public void setCoins() {
        if (coinsEnum == GameCoinsEnum.OUR) {
            //
        }
    }

    public void takeCoins() {
        if (coinsEnum == GameCoinsEnum.OUR) {
            //
        }
    }

    public int getCoins() {
        if (coinsEnum == GameCoinsEnum.OUR) {
            //
        }
        return 0;
    }

}
