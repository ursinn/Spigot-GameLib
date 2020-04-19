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

package dev.ursinn.spigot.gamelib.enums;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;

/**
 * Enum - Color
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public enum GameColorEnum {

    GREEN(ChatColor.GREEN, DyeColor.LIME),
    RED(ChatColor.RED, DyeColor.RED),
    BLUE(ChatColor.BLUE, DyeColor.LIGHT_BLUE),
    YELLOW(ChatColor.YELLOW, DyeColor.YELLOW),
    AQUA(ChatColor.AQUA, DyeColor.CYAN),
    BLACK(ChatColor.BLACK, DyeColor.BLACK),
    GOLD(ChatColor.GOLD, DyeColor.ORANGE),
    DARK_BLUE(ChatColor.DARK_BLUE, DyeColor.BLUE),
    DARK_GREEN(ChatColor.DARK_GREEN, DyeColor.GREEN),
    DARK_RED(ChatColor.DARK_RED, DyeColor.BROWN),
    DARK_PURPLE(ChatColor.DARK_PURPLE, DyeColor.MAGENTA),
    GRAY(ChatColor.GRAY, DyeColor.SILVER),
    DARK_GRAY(ChatColor.DARK_GRAY, DyeColor.GRAY),
    LIGHT_PURPLE(ChatColor.LIGHT_PURPLE, DyeColor.PINK),
    WHITE(ChatColor.WHITE, DyeColor.WHITE);

    private final ChatColor chatColor;
    private final DyeColor dyeColor;

    GameColorEnum(ChatColor chatColor, DyeColor dyeColor) {
        this.chatColor = chatColor;
        this.dyeColor = dyeColor;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public DyeColor getDyeColor() {
        return dyeColor;
    }
}
