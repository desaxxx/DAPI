package org.nandayo.dapi.service;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class Platform {

    static private Platform.Type type;

    /**
     * Get the platform type of running server.
     * @return Platform.Type
     */
    @NotNull
    static public Platform.Type getType() {
        if(type != null) return type;
        String serverName = Bukkit.getServer().getName();
        switch (serverName.toLowerCase()) {
            case "leaf":
                return type = Type.LEAF;
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
     * Check if the server is running on Leaf.
     * @return Whether leaf or not.
     */
    static public boolean isLeaf() {
        return getType() == Type.LEAF;
    }

    /**
     * Check if the server is running Paper.
     * @return Whether paper or not.
     */
    static public boolean isPaper() {
        return getType() == Type.PAPER;
    }

    /**
     * Check if the server is running Purpur.
     * @return Whether purpur or not.
     */
    static public boolean isPurpur() {
        return getType() == Type.PURPUR;
    }

    /**
     * Check if the server is running PufferFish.
     * @return Whether pufferfish or not.
     */
    static public boolean isPufferfish() {
        return getType() == Type.PUFFERFISH;
    }

    /**
     * Check if the server is running Spigot.
     * @return Whether spigot or not.
     */
    static public boolean isSpigot() {
        return getType() == Type.SPIGOT;
    }

    /**
     * Check if the server is running Paper or any of its fork.
     * @return Whether paper or any of its fork.
     */
    static public boolean isPaperFork() {
        if(isPaper() || isPurpur() || isPufferfish() || isLeaf()) return true;
        if(isSpigot()) return false;
        // for case Platform.Type#OTHER
        try {
            Class.forName("com.destroystokyo.paper.PaperConfig");
            return true;
        } catch (ClassNotFoundException ignored) {
            return false;
        }
    }




    public enum Type {
        LEAF,
        PAPER,
        PUFFERFISH,
        PURPUR,
        SPIGOT,
        OTHER
        ;
    }
}
