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

import dev.ursinn.spigot.gamelib.Arena;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

/**
 * Helper - Arena
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GameArenaHelper {

    private final Plugin plugin;
    private final File file;
    private final FileConfiguration configuration;

    /**
     * Constructor
     *
     * @param plugin Plugin instance
     * @since 1.0
     */
    public GameArenaHelper(Plugin plugin) {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), "arenas.yml");
        configuration = new YamlConfiguration();
        load();
    }

    /**
     * Add a Arena
     *
     * @param arena Arena
     * @since 1.0
     */
    public void addArena(Arena arena) {
        // TODO
        save();
    }

    /**
     * Remove a Arena
     *
     * @param name Name of the Arena
     * @since 1.0
     */
    public void removeMap(String name) {
        // TODO
        save();
    }

    /**
     * Save The File to the Disk
     *
     * @since 1.0
     */
    private void save() {
        try {
            if (!file.exists())
                configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load The File from the Disk
     *
     * @since 1.0
     */
    public void load() {
        try {
            configuration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
