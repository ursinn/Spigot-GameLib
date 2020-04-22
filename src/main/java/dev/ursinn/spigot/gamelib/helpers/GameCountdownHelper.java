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

import dev.ursinn.spigot.gamelib.events.GameCountdownEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * Util - Countdown
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class GameCountdownHelper {

    private final Plugin plugin;
    private int taskId;
    private int countdown;

    /**
     * Constructor
     *
     * @param plugin    Plugin instance
     * @param countdown Time
     * @since 1.0
     */
    public GameCountdownHelper(Plugin plugin, int countdown) {
        this.countdown = countdown;
        this.plugin = plugin;
    }

    /**
     * Run the Countdown
     *
     * @since 1.0
     */
    public void run() {
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            Bukkit.getPluginManager().callEvent(new GameCountdownEvent(countdown));
            if (countdown == 0) {
                Bukkit.getScheduler().cancelTask(taskId);
            }
            countdown--;
        }, 0L, 20L);
    }

    /**
     * Stop the Countdown
     *
     * @since 1.0
     */
    public void stop() {
        Bukkit.getScheduler().cancelTask(taskId);
    }

    /**
     * Get Time
     *
     * @return Time left
     * @since 1.0
     */
    public int getCountdown() {
        return countdown;
    }

    /**
     * Set Time
     *
     * @param countdown Time
     * @since 1.0
     */
    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }
}
