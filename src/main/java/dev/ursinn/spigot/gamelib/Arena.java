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

import java.util.ArrayList;
import java.util.UUID;

/**
 * Game - Arena
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class Arena {

    private final String name;
    private GameMap map;
    private final Location lobby;
    private final ArrayList<UUID> players = new ArrayList<>();

    /**
     * Constructor
     *
     * @param name Arena name
     * @param map GameMap
     * @param lobby Lobby Location
     */
    public Arena(String name, GameMap map, Location lobby) {
        this.name = name;
        this.map = map;
        this.lobby = lobby;
    }

    /**
     * Get Arena name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get GameMap
     *
     * @return GameMap
     */
    public GameMap getMap() {
        return map;
    }

    /**
     * Set GameMap
     *
     * @param map GameMap
     */
    public void setMap(GameMap map) {
        this.map = map;
    }

    /**
     * Get Lobby Location
     *
     * @return Location
     */
    public Location getLobby() {
        return lobby;
    }

    /**
     * Get Players
     *
     * @return Players of Arena
     */
    public ArrayList<UUID> getPlayers() {
        return players;
    }

    /**
     * Add Player
     *
     * @param uuid Player UUID
     */
    public void addPlayer(UUID uuid) {
        players.add(uuid);
    }

    /**
     * Remove Player
     *
     * @param uuid Player UUID
     */
    public void removePlayer(UUID uuid) {
        players.remove(uuid);
    }
}
