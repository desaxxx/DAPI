package org.nandayo.dapi.model;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@SuppressWarnings("unused")
public class BoundingBox {

    private final Point minPoint;
    private final Point maxPoint;
    private final String worldName;

    public BoundingBox(@NotNull Point point1, @NotNull Point point2, @NotNull String worldName) {
        this.minPoint = Point.getMinimum(point1, point2);
        this.maxPoint = Point.getMaximum(point1, point2);
        this.worldName = worldName;
    }

    @Nullable
    public World getWorld() {
        return Bukkit.getWorld(worldName);
    }

    @Nullable
    public Location getMinimumLocation() {
        if(getWorld() == null) return null;
        return minPoint.toLocation(getWorld());
    }

    @Nullable
    public Location getMaximumLocation() {
        if(getWorld() == null) return null;
        return maxPoint.toLocation(getWorld());
    }

    public boolean isInside(@NotNull Point point) {
        return (point.getX() >= minPoint.getX() && point.getX() <= maxPoint.getX())
                && (point.getY() >= minPoint.getY() && point.getY() <= maxPoint.getY())
                && (point.getZ() >= minPoint.getZ() && point.getZ() <= maxPoint.getZ());
    }

    public boolean isInside(@NotNull Location location) {
        return this.isInside(new Point(location));
    }

    public String parseString() {
        return worldName + ",[" + getMinPoint().getX() + "_" + getMinPoint().getY() + "_" + getMinPoint().getZ() + "],[" + getMaxPoint().getX() + "_" + getMaxPoint().getY() + "_" + getMaxPoint().getZ() + "]";
    }

    @NotNull
    static public BoundingBox fromString(@NotNull String str) {
        String[] split = str.split(",");
        String worldName = split[0];

        String[] point1split = split[1].replace("[", "").replace("]", "").split("_");
        Point minPoint = new Point(Integer.parseInt(point1split[0]), Integer.parseInt(point1split[1]), Integer.parseInt(point1split[2]));

        String[] point2split = split[2].replace("[", "").replace("]", "").split("_");
        Point maxPoint = new Point(Integer.parseInt(point2split[0]), Integer.parseInt(point2split[1]), Integer.parseInt(point2split[2]));

        return new BoundingBox(minPoint, maxPoint, worldName);
    }
}