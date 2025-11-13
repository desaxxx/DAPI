package org.nandayo.dapi.configuration;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @since 1.4.0, relocated since 1.5.1
 */
@Getter
@SuppressWarnings("unused")
public abstract class YAMLRegistry {

    private final @NotNull JavaPlugin plugin;
    protected YAMLRegistry(@NotNull JavaPlugin plugin) {
        this.plugin = plugin;
        loadFile();
        REGISTRIES.add(this);
    }

    private File file;

    abstract protected @NotNull String filePath();

    /**
     * Load file of the given set-up. Creates a default one if it doesn't exist.
     */
    protected void loadFile() {
        String path = filePath();
        File file = new File(plugin.getDataFolder(), path);
        if(!file.exists()) {
            if (!file.getParentFile().exists()) //noinspection ResultOfMethodCallIgnored
                file.getParentFile().mkdirs();
            saveDefaultResource();
        }
        this.file = file;
    }

    /**
     * Get the InputStream of the given path.
     * @return InputStream
     */
    private InputStream getDefaultResource() {
        return plugin.getResource(filePath());
    }

    /**
     * Save default resource of the given path.
     */
    private void saveDefaultResource() {
        if(getDefaultResource() != null) {
            plugin.saveResource(filePath(), false);
        }
    }

    /**
     * Get the FileConfiguration from the set-up file.
     * @return FileConfiguration
     */
    @NotNull
    protected FileConfiguration getConfiguration() {
        return YamlConfiguration.loadConfiguration(file);
    }

    abstract public boolean isLoaded();
    abstract public void setLoaded(boolean loaded);

    abstract public void onLoad();
    abstract public void onUnload();




    private static final @NotNull List<YAMLRegistry> REGISTRIES = new ArrayList<>();

    /**
     * Get unmodifiable list of {@link #REGISTRIES}.
     * @return List of YAMLRegistry
     */
    public static List<YAMLRegistry> getRegistries() {
        return Collections.unmodifiableList(REGISTRIES);
    }

    /**
     * Runs the method {@link #onLoad()} for ALL YAMLRegistries.
     * @apiNote Recommended to use on start of the run-time.
     */
    public static void loadRegistries() {
        for (YAMLRegistry registry : REGISTRIES) {
            registry.onLoad();
        }
    }

    /**
     * Runs the method {@link #onUnload()} for ALL YAMLRegistries.
     * The <b>Registry</b> won't be unloaded unless {@link #isLoaded()} returns true.
     * @apiNote Recommended to use before stop of the run-time.
     */
    public static void unloadRegistries() {
        for (YAMLRegistry registry : REGISTRIES) {
            if(!registry.isLoaded()) continue;
            registry.onUnload();
        }
    }
}
