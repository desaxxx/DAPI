package org.nandayo.dapi.color;

import lombok.Getter;
import org.bukkit.Color;
import org.jetbrains.annotations.ApiStatus;
import org.nandayo.dapi.util.Validate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @since 1.3.3
 */
@ApiStatus.Experimental
@SuppressWarnings("unused")
public class DColor {
    public static final char LEGACY_COLOR_CHAR = '§';
    public static final char LEGACY_ALTERNATIVE_CHAR = '&';
    public static final String LEGACY_ALL_CODES = "0123456789ABCDEFKLMNORX";
    public static final String LEGACY_COLOR_CODES = "0123456789ABCDEF";
    public static final String LEGACY_DECORATION_CODES = "KLMNOR";
    public static final char LEGACY_HEX_CHAR = 'X';

    private static final Map<String, DColor> LEGACY_CODE_MAP = new HashMap<>();
    private static final Map<String, DColor> MINIMESSAGE_FORMAT_MAP = new HashMap<>();


    //================
    // Colors
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

    //================
    // Decorations
    //================

    public static final DColor BOLD = new DColor("l", "<bold>");
    public static final DColor ITALIC = new DColor("o", "<italic>");
    public static final DColor OBFUSCATED = new DColor("k", "<obfuscated>");
    public static final DColor RESET = new DColor("r", "<reset>");
    public static final DColor STRIKETHROUGH = new DColor("m", "<strikethrough>");
    public static final DColor UNDERLINED = new DColor("n", "<underlined>");


    /**
     * Color of Bukkit
     */
    @Getter
    private final Color color;
    /**
     * Legacy code of Minecraft itself.<br>
     * E.g. a, b, c, k, l, m, XRRGGBB
     */
    @Getter
    private final String legacyCode;
    /**
     * MiniMessage format.<br>
     * E.g. <aqua>, <red>, <bold>, <underlined>, <#RRGGBB>
     */
    @Getter
    private final String miniMessageFormat;

    private DColor(Color color, String legacyCode, String miniMessageFormat) {
        this.color = color;
        this.legacyCode = legacyCode;
        this.miniMessageFormat = miniMessageFormat;

        LEGACY_CODE_MAP.put(legacyCode, this);
        MINIMESSAGE_FORMAT_MAP.put(miniMessageFormat, this);
    }

    private DColor(String legacyCode, String miniMessageFormat) {
        this(null, legacyCode, miniMessageFormat);
    }

    public DColor(String hexString) {
        Validate.validate(hexString.length() == 7 && hexString.charAt(0) == '#', "Invalid hex string.");
        int rgb = Validate.validateReturn(() -> Integer.parseInt(hexString.substring(1), 16), "Invalid hex format.");
        this.color = Color.fromRGB(rgb);
        this.legacyCode = "X" + hexString;
        this.miniMessageFormat = "<#" + hexString + ">";
    }

    public DColor(Color color) {
        this.color = color;
        String hexString = Validate.validateReturn(() -> String.format("%06X", color.asRGB()), "Invalid hex legacy color.");
        this.legacyCode = "X" + hexString;
        this.miniMessageFormat = "<#" + hexString + ">";
    }

    public DColor(int rgb) {
        this(Color.fromRGB(rgb));
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

    public static DColor getByLegacyCode(String legacyCode) {
        return LEGACY_CODE_MAP.get(legacyCode);
    }

    public static DColor getByMiniMessageFormat(String miniMessageFormat) {
        Validate.notNull(miniMessageFormat, "miniMessage format cannot be null!");
        return MINIMESSAGE_FORMAT_MAP.get(miniMessageFormat);
    }


}
