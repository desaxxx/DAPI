package org.nandayo.dapi.service;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class Platform {

    static private Type type;

    /**
     * Get the platform type of running server.
     * @return Platform.Type
     */
    @NotNull
    static public Type getPlatform() {
        if(type != null) return type;
        String serverName = Bukkit.getServer().getName();
        switch (serverName.toLowerCase()) {
            case "paper":
                return type = Type.PAPER;
            case "purpur":
                return type = Type.PURPUR;
            case "pufferfish":
                return type = Type.PUFFERFISH;
            case "craftbukkit":
                return type = Type.SPIGOT;
            default:
                return type = Type.OTHER;
        }
    }

    /**
     * Check if the server is running Paper.
     * @return Whether paper or not.
     */
    static public boolean isPaper() {
        return getPlatform() == Type.PAPER;
    }

    /**
     * Check if the server is running Purpur.
     * @return Whether purpur or not.
     */
    static public boolean isPurpur() {
        return getPlatform() == Type.PURPUR;
    }

    /**
     * Check if the server is running PufferFish.
     * @return Whether pufferfish or not.
     */
    static public boolean isPufferfish() {
        return getPlatform() == Type.PUFFERFISH;
    }

    /**
     * Check if the server is running Spigot.
     * @return Whether spigot or not.
     */
    static public boolean isSpigot() {
        return getPlatform() == Type.SPIGOT;
    }

    /**
     * Check if the server is running Paper or any of its fork.
     * @return Whether paper or any of its fork.
     */
    static public boolean isPaperFork() {
        return isPaper() || isPurpur() || isPufferfish();
    }




    public enum Type {
        PAPER,
        PUFFERFISH,
        PURPUR,
        SPIGOT,
        OTHER
        ;
    }
}
