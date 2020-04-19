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

package dev.ursinn.spigot.gamelib.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Util - Method
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GameMethodUtils {

    private final Plugin plugin;

    /**
     * Constructor
     *
     * @param plugin Plugin Instance
     * @since 1.0
     */
    public GameMethodUtils(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Sends Player to Server Name
     * Requires BungeeCord
     *
     * @param player Player
     * @param server Server Name
     * @since 1.0
     */
    public void sendServer(Player player, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);

        player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }

    /**
     * Teleport All Players to Location
     *
     * @param location Location
     * @since 1.0
     */
    public void teleport(Location location) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.teleport(location);
        }
    }

    /**
     * Spawns a Villager (NPC)
     *
     * @param name Villager Name
     * @param location Location
     * @since 1.0
     */
    public void spawnVillager(String name, Location location) {
        Villager villager = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        villager.setCustomName(name);
        villager.setCustomNameVisible(true);
        villager.setAdult();
        villager.setCanPickupItems(false);
        PotionEffect effect = new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, Integer.MAX_VALUE);
        villager.addPotionEffect(effect);
    }

    /**
     * Respawn a Player
     *
     * @param player Player
     * @since 1.0
     */
    public void respawn(Player player) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> player.spigot().respawn(), 1L);
    }

    /**
     * Some World Settings
     *
     * @param name World Name
     * @since 1.0
     */
    public void worldSettings(String name) {
        Bukkit.getWorld(name).setAutoSave(false);
        Bukkit.getWorld(name).setThundering(false);
        Bukkit.getWorld(name).setStorm(false);
        Bukkit.getWorld(name).setTime(0L);
        Bukkit.getWorld(name).setGameRuleValue("doDaylightCycle", "false");
        Bukkit.getWorld(name).setGameRuleValue("announceAdvancements", "false");
        Bukkit.getWorld(name).setGameRuleValue("doFireTick", "false");
        Bukkit.getWorld(name).setGameRuleValue("doMobSpawning", "false");
    }

    /**
     * Runs worldSettings on All Loaded Worlds
     * @see #worldSettings(String)
     *
     * @since 1.0
     */
    public void worldSettings() {
        for (World world : Bukkit.getWorlds()) {
            worldSettings(world.getName());
        }
    }

}
