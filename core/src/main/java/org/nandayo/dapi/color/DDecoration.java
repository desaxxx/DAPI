package org.nandayo.dapi.color;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.util.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 1.4.0
 */
@SuppressWarnings("unused")
public class DDecoration implements DStyle {
    public static final String LEGACY_DECORATION_CODES = "KLMNOR";
    public static final String MINI_MESSAGE_CLEAR = "<!b><!i><!obf><!st><!u>";

    private static final Map<String, DDecoration> LEGACY_CODE_MAP = new HashMap<>();
    private static final Map<String, DDecoration> MINIMESSAGE_FORMAT_MAP = new HashMap<>();

    //================
    // Named Decorations
    //================

    public static final DDecoration BOLD = new DDecoration("l", "<bold>");
    public static final DDecoration ITALIC = new DDecoration("o", "<italic>");
    public static final DDecoration OBFUSCATED = new DDecoration("k", "<obfuscated>");
    public static final DDecoration RESET = new DDecoration("r", "<reset>");
    public static final DDecoration STRIKETHROUGH = new DDecoration("m", "<strikethrough>");
    public static final DDecoration UNDERLINED = new DDecoration("n", "<underlined>");


    /**
     * Legacy code of Minecraft itself.<br>
     * E.g. k, l, m
     */
    @Getter
    private final String legacyCode;
    /**
     * MiniMessage format.<br>
     * E.g. <bold>, <underlined>
     */
    @Getter
    private final String miniMessageFormat;

    private DDecoration(String legacyCode, String miniMessageFormat) {
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


    //================
    // Static
    //================

    @Nullable
    public static DDecoration getByLegacyCode(String legacyCode) {
        Validate.notNull(legacyCode, "Legacy code cannot be null.");
        return LEGACY_CODE_MAP.get(legacyCode);
    }

    @Nullable
    public static DDecoration getByMiniMessageFormat(String miniMessageFormat) {
        Validate.notNull(miniMessageFormat, "miniMessage format cannot be null.");
        return MINIMESSAGE_FORMAT_MAP.get(miniMessageFormat);
    }
}
