package org.nandayo.dapi.color;

import lombok.Getter;
import org.bukkit.Color;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.util.Validate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @since 1.3.3
 */
@ApiStatus.Experimental
@SuppressWarnings("unused")
public class DColor implements DStyle {
    public static final String LEGACY_COLOR_CODES = "0123456789ABCDEF";
    public static final char LEGACY_HEX_CHAR = 'X';
    public static final char MINIMESSAGE_HEX_CHAR = '#';

    private static final Map<String, DColor> LEGACY_CODE_MAP = new HashMap<>();
    private static final Map<String, DColor> MINIMESSAGE_FORMAT_MAP = new HashMap<>();

    //================
    // Named Colors
    //================

    public static final DColor AQUA = new DColor(Color.fromRGB(5636095), "b", "<aqua>");
    public static final DColor BLACK = new DColor(Color.fromRGB(0), "0", "<black>");
    public static final DColor BLUE = new DColor(Color.fromRGB(5592575), "9", "<blue>");
    public static final DColor DARK_AQUA = new DColor(Color.fromRGB(43690), "3", "<dark_aqua>");
    public static final DColor DARK_BLUE = new DColor(Color.fromRGB(170), "1", "<dark_blue>");
    public static final DColor DARK_GRAY = new DColor(Color.fromRGB(5592405), "8", "<dark_gray>");
    public static final DColor DARK_GREEN = new DColor(Color.fromRGB(43520), "2", "<dark_green>");
    public static final DColor DARK_PURPLE = new DColor(Color.fromRGB(11141290), "5", "<dark_purple>");
    public static final DColor DARK_RED = new DColor(Color.fromRGB(11141120), "4", "<dark_red>");
    public static final DColor GRAY = new DColor(Color.fromRGB(11184810), "7", "<gray>");
    public static final DColor GOLD = new DColor(Color.fromRGB(16755200), "6", "<gold>");
    public static final DColor GREEN = new DColor(Color.fromRGB(5635925), "a", "<green>");
    public static final DColor LIGHT_PURPLE = new DColor(Color.fromRGB(16733695), "d", "<light purple>");
    public static final DColor RED = new DColor(Color.fromRGB(16733525), "c", "<red>");
    public static final DColor WHITE = new DColor(Color.fromRGB(16777215), "f", "<white>");
    public static final DColor YELLOW = new DColor(Color.fromRGB(16777045), "e", "<yellow>");


    /**
     * Color of Bukkit
     */
    @Getter
    private final @NotNull Color color;
    /**
     * Legacy code of Minecraft itself.<br>
     * E.g. a, b, c, XRRGGBB
     */
    @Getter
    private final @NotNull String legacyCode;
    /**
     * MiniMessage format.<br>
     * E.g. <aqua>, <red>, <#RRGGBB>
     */
    @Getter
    private final @NotNull String miniMessageFormat;

    private DColor(Color color, String legacyCode, String miniMessageFormat) {
        Validate.notNull(color, "Color cannot be null.");
        Validate.notNull(legacyCode, "Legacy code cannot be null.");
        Validate.notNull(miniMessageFormat, "MiniMessage format cannot be null.");

        this.color = color;
        this.legacyCode = legacyCode;
        this.miniMessageFormat = miniMessageFormat;

        LEGACY_CODE_MAP.put(legacyCode, this);
        MINIMESSAGE_FORMAT_MAP.put(miniMessageFormat, this);
    }


    @Override
    @NotNull
    public String insertLegacyStyleChar() {
        return legacyCode.replaceAll(".", LEGACY_STYLE_CHAR + "$0");
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DColor dColor = (DColor) o;
        return Objects.equals(legacyCode, dColor.legacyCode) && Objects.equals(color, dColor.color) && Objects.equals(miniMessageFormat, dColor.miniMessageFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, legacyCode, miniMessageFormat);
    }







    //================
    // Static
    //================


    @NotNull
    private static DColor of(String hexString, Color color) {
        return new DColor(color, LEGACY_HEX_CHAR + hexString, "<" + MINIMESSAGE_HEX_CHAR + hexString + ">");
    }

    @NotNull
    public static DColor of(Color color) {
        Validate.notNull(color, "Color cannot be null.");
        String hexString = Validate.validateReturn(() -> String.format("%06X", color.asRGB()), "Invalid hex color.");
        return of(hexString, color);
    }

    @NotNull
    public static DColor of(int rgb) {
        Color color = Validate.validateReturn(() -> Color.fromRGB(rgb), "Invalid rgb color.");
        return of(color);
    }

    @NotNull
    public static DColor of(String hexString) {
        Validate.notNull(hexString, "Hex string cannot be null.");
        Validate.validate(hexString.length() == 7 && hexString.charAt(0) == MINIMESSAGE_HEX_CHAR, "Invalid hex string.");
        int rgb = Validate.validateReturn(() -> Integer.parseInt(hexString.substring(1), 16), "Invalid hex format.");
        return of(rgb);
    }



    @NotNull
    public static DColor interpolate(DColor start, DColor end, float ratio) {
        return interpolate(start.getColor(), end.getColor(), ratio);
    }

    @NotNull
    public static DColor interpolate(Color start, Color end, float ratio) {
        Validate.notNull(start, "Start color cannot be null.");
        Validate.notNull(end, "End color cannot be null.");
        Validate.validate(ratio >= 0 && ratio <= 1, "Ratio must be between 0 and 1.");

        int red = (int) (start.getRed() + ratio * (end.getRed() - start.getRed()));
        int green = (int) (start.getGreen() + ratio * (end.getGreen() - start.getGreen()));
        int blue = (int) (start.getBlue() + ratio * (end.getBlue() - start.getBlue()));
        return of(Color.fromRGB(red, green, blue));
    }





    @Nullable
    public static DColor getByLegacyCode(String legacyCode) {
        Validate.notNull(legacyCode, "Legacy code cannot be null.");
        if(LEGACY_CODE_MAP.containsKey(legacyCode)) {
            return LEGACY_CODE_MAP.get(legacyCode);
        }
        // case of XRRGGBB -> of(#RRGGBB)
        else if(legacyCode.length() == 7 && legacyCode.charAt(0) == LEGACY_HEX_CHAR) {
            return DColor.of(MINIMESSAGE_HEX_CHAR + legacyCode.substring(1));
        }
        return null;
    }

    @Nullable
    public static DColor getByMiniMessageFormat(String miniMessageFormat) {
        Validate.notNull(miniMessageFormat, "miniMessage format cannot be null.");
        return MINIMESSAGE_FORMAT_MAP.get(miniMessageFormat);
    }
}
