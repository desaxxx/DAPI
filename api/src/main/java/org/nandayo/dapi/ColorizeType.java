package org.nandayo.dapi;

public enum ColorizeType {
    LEGACY,
    MINI_MESSAGE;



    public String apply(String text) {
        if (this == ColorizeType.MINI_MESSAGE) {
            return HexUtil.colorToMiniMessage(text);
        }
        return HexUtil.colorize(text);
    }
}
