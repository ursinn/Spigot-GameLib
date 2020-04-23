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

package dev.ursinn.spigot.gamelib;

import org.bukkit.Location;

/**
 * Game - Map
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GameMap {

    private final String name;
    private final String authors;
    private final Location spawn;
    private final int maxPlayers;
    private final int spawnProtectionBottomHeight;
    private final int bottomHeight;
    private final int topHeight;

    /**
     * Constructor
     *
     * @param name                        Map Name
     * @param authors                     Map Authors
     * @param spawn                       Spawn Location
     * @param maxPlayers                  max Players for Map
     * @param spawnProtectionBottomHeight Spawn Protection Height (Used in Some Games)
     * @param bottomHeight                Bottom Height (Used in Some Games)
     * @param topHeight                   Top Height (Used in Some Games)
     */
    public GameMap(String name, String authors, Location spawn, int maxPlayers, int spawnProtectionBottomHeight, int bottomHeight, int topHeight) {
        this.name = name;
        this.authors = authors;
        this.spawn = spawn;
        this.maxPlayers = maxPlayers;
        this.spawnProtectionBottomHeight = spawnProtectionBottomHeight;
        this.bottomHeight = bottomHeight;
        this.topHeight = topHeight;
    }

    public String getName() {
        return name;
    }

    public String getAuthors() {
        return authors;
    }

    public Location getSpawn() {
        return spawn;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getSpawnProtectionBottomHeight() {
        return spawnProtectionBottomHeight;
    }

    public int getBottomHeight() {
        return bottomHeight;
    }

    public int getTopHeight() {
        return topHeight;
    }
}
