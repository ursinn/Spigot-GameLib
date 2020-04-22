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

import dev.ursinn.spigot.gamelib.GameMap;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

/**
 * Helper - Map
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GameMapHelper {

    File file;
    FileConfiguration configuration;

    public GameMapHelper(Plugin plugin) {
        this.file = new File(plugin.getDataFolder(), "maps.yml");
        configuration = new YamlConfiguration();
        load();
    }

    public GameMap getRandomMap() {
        return new GameMap("Map-A", "Map-A Authors", null, 20, 83, 0, 255);
    }

    public GameMap getNullMap() {
        return new GameMap("", "", null, 0, 0, 0, 0);
    }

    public void addMap(GameMap map) {
        // TODO
        save();
    }

    public void removeMap(String name) {
        // TODO
        save();
    }

    public void save() {
        try {
            if (!file.exists())
                configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            configuration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
