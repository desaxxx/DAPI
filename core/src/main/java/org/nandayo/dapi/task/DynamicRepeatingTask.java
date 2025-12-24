package org.nandayo.dapi.task;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.nandayo.dapi.util.Validate;

/**
 * @since 1.5.1
 */
@SuppressWarnings("unused")
public abstract class DynamicRepeatingTask {

    private final Plugin plugin;
    private long tickSpeed;

    private BukkitRunnable current;

    public DynamicRepeatingTask(Plugin plugin, long initialSpeed) {
        Validate.notNull(plugin, "Plugin is null.");
        this.plugin = plugin;
        this.tickSpeed = initialSpeed;
    }

    public long getTickSpeed() {
        return tickSpeed;
    }

    public void setTickSpeed(long tickSpeed) {
        this.tickSpeed = Math.max(1, tickSpeed);
    }

    abstract public void run();

    public void start() {
        if(isRunning()) return;
        scheduleNext();
    }

    private void scheduleNext() {
        this.current = new BukkitRunnable() {
            @Override
            public void run() {
                DynamicRepeatingTask.this.run();
                if(!isRunning()) return;
                scheduleNext();
            }
        };
        current.runTaskLater(plugin, tickSpeed);
    }

    public void cancel() {
        if(!isRunning()) return;
        current.cancel();
        current = null;
    }

    public boolean isRunning() {
        return current != null && !current.isCancelled();
    }
}