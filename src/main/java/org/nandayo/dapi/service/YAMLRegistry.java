package org.nandayo.dapi.service;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    abstract public void onLoad();
    abstract public void onUnload();




    static private final @NotNull List<YAMLRegistry> REGISTRIES = new ArrayList<>();

    /**
     * Get immutable list of YAMLRegistries.
     * @return List of YAMLRegistry
     */
    static public List<YAMLRegistry> getRegistries() {
        return ImmutableList.copyOf(REGISTRIES);
    }

    /**
     * Runs the method {@link #onLoad()} for ALL YAMLRegistries.
     * @apiNote Recommended to use on start of the run-time.
     */
    static public void loadRegistries() {
        for (YAMLRegistry registry : REGISTRIES) {
            registry.onLoad();
        }
    }

    /**
     * Runs the method {@link #onUnload()} for ALL YAMLRegistries.
     * @apiNote Recommended to use before stop of the run-time.
     */
    static public void unloadRegistries() {
        for (YAMLRegistry registry : REGISTRIES) {
            registry.onUnload();
        }
    }
}
