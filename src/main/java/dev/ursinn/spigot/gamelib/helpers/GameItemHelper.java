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

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Util - Item
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GameItemHelper {

    private final Material material;

    /**
     * Constructor
     *
     * @param material Item Material
     * @since 1.0
     */
    public GameItemHelper(Material material) {
        this.material = material;
    }

    /**
     * Get Item
     *
     * @return Item
     * @since 1.0
     */
    public ItemStack getItem() {
        return new ItemStack(material);
    }

    /**
     * Get Item with Custom Name
     *
     * @param name Item Name
     * @return Item
     * @since 1.0
     */
    public ItemStack getItem(String name) {
        ItemStack item = getItem();
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Get Item that is Unbreakable with Custom Name
     *
     * @param name Item Name
     * @return Item
     * @since 1.0
     */
    public ItemStack getItemUnbreakable(String name) {
        ItemStack item = getItem(name);
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Get Item with Custom Name
     *
     * @param name Item Name
     * @param amount Amount
     * @return ItemStack
     * @since 1.0
     */
    public ItemStack getItem(String name, int amount) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Get Item that is Unbreakable with Custom Name
     *
     * @param name Item Name
     * @param amount Amount
     * @return ItemStack
     * @since 1.0
     */
    public ItemStack getItemUnbreakable(String name, int amount) {
        ItemStack item = getItem(name, amount);
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Get Item with Custom Name
     *
     * @param name Item Name
     * @param amount Amount
     * @param lore Item Lore
     * @return ItemStack
     * @since 1.0
     */
    public ItemStack getItem(String name, int amount, List<String> lore) {
        ItemStack item = getItem(name, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Get Item that is Unbreakable with Custom Name and Lore
     *
     * @param name Item name
     * @param amount Amount
     * @param lore Item Lore
     * @return ItemStack
     * @since 1.0
     */
    public ItemStack getItemUnbreakable(String name, int amount, List<String> lore) {
        ItemStack item = getItem(name, amount, lore);
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Get Item with Custom Name
     *
     * @param name Item Name
     * @param amount Amount
     * @param damage Item Damage
     * @return ItemStack
     * @since 1.0
     */
    public ItemStack getItem(String name, int amount, short damage) {
        ItemStack item = getItem(name, amount);
        item.setDurability(damage);
        return item;
    }

    /**
     * Get Item with Custom Name and Lore
     *
     * @param name Item Name
     * @param amount Amount
     * @param lore Item Lore
     * @param damage Item Damage
     * @return ItemStack
     * @since 1.0
     */
    public ItemStack getItem(String name, int amount, List<String> lore, short damage) {
        ItemStack item = getItem(name, amount);
        item.setDurability(damage);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

}
