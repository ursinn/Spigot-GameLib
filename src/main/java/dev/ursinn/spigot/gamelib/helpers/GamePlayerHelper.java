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

import org.bukkit.GameMode;
import org.bukkit.inventory.PlayerInventory;

/**
 * Helper - Player
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GamePlayerHelper {

    private PlayerInventory inventory;
    private GameMode gameMode;

    /**
     * Constructor
     *
     * @param inventory Player Inventory
     * @param gameMode Player GameMode
     * @since 1.0
     */
    public GamePlayerHelper(PlayerInventory inventory, GameMode gameMode) {
        this.inventory = inventory;
        this.gameMode = gameMode;
    }

    /**
     * Get The Players saved Inventory
     *
     * @return Player Inventory
     * @since 1.0
     */
    public PlayerInventory getInventory() {
        return inventory;
    }

    /**
     * Get The Players saved GameMode
     *
     * @return Player GameMode
     * @since 1.0
     */
    public GameMode getGameMode() {
        return gameMode;
    }

}
