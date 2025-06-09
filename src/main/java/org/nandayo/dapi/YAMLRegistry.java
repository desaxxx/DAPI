package org.nandayo.dapi;

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
        if (!file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.mkdirs();
            saveDefaultResource(path);
        }
        this.file = file;
    }

    /**
     * Get the InputStream of the given path.
     * @param path Path of the requested file
     * @return InputStream
     */
    private InputStream getDefaultResource(@NotNull String path) {
        return plugin.getResource(path);
    }

    /**
     * Save default resource of the given path.
     * @param path Path of the requested file
     */
    private void saveDefaultResource(@NotNull String path) {
        if(getDefaultResource(path) != null) {
            plugin.saveResource(path, false);
        }
    }

    /**
     * Get the FileConfiguration from the set-up file.
     * @return FileConfiguration
     */
    @NotNull
    protected FileConfiguration getConfiguration() {
        YamlConfiguration config = new YamlConfiguration();
        try {
            config.load(file);
        } catch (Exception e) {
            Util.log(String.format("Couldn't load YAML configuration '%s'!", file.getName()));
        }
        return config;
    }

    abstract void onLoad();
    abstract void onUnload();




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
