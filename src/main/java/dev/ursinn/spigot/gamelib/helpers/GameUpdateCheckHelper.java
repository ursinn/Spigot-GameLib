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

import org.bukkit.plugin.Plugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Helper - Update Checker
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GameUpdateCheckHelper {

    private final int id;
    private final Plugin plugin;
    private boolean update;
    public Thread checkUpdates = new Thread() {
        public void run() {
            try {
                URLConnection conn = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + id).openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String oldVersion = plugin.getDescription().getVersion();
                String newVersion = br.readLine();
                if (!newVersion.equals(oldVersion)) {
                    update = true;
                    plugin.getLogger().info("An update for " + plugin.getDescription().getName() + " is available");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * Constructor
     *
     * @param id Spigot Plugin Id
     * @param plugin Plugin instance
     * @since 1.0
     */
    public GameUpdateCheckHelper(int id, Plugin plugin) {
        this.id = id;
        this.plugin = plugin;
    }

    /**
     * Check if a Update available
     *
     * @return Update status
     * @since 1.0
     */
    public boolean isUpdate() {
        return update;
    }
}