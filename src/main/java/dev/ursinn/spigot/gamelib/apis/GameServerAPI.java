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
import dev.ursinn.spigot.gamelib.enums.GameStatusEnum;

/**
 * API - Server API
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GameServerAPI {

    private final SqlDatabase db;
    private final String table;

    /**
     * Constructor
     *
     * @param prefix Table Prefix or null
     * @param db     Database
     * @since 1.0
     */
    public GameServerAPI(String prefix, SqlDatabase db) {
        this.db = db;
        if (prefix != null)
            this.table = prefix + "_servers";
        else
            this.table = "servers";
    }

    public void init() {
        // TODO
    }

    public void insert(String serverId, String game) {
        // TODO
    }

    public void updateMap(String map) {
        // TODO
    }

    public void updateStatus(GameStatusEnum statusEnum) {
        // TODO
    }

    public void updateOnline(int online) {
        // TODO
    }

    public void updateMax(int max) {
        // TODO
    }

}
