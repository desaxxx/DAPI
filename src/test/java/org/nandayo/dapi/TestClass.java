package org.nandayo.dapi;

import org.junit.jupiter.api.Test;
import org.nandayo.dapi.util.HexUtil;

public class TestClass {

    @Test
    void testColors() {
        String s1 = "<aqua>Aqua, <light_purple>Light purple, <dark_blue>Dark blue, <#ff00bb>Hex-1, &#cc44ffHex-2, <italic>Italic, <bold>Bold, &nUnderline, &6Orange, &rReset, &0Black, &cRed, &6Another orange, &kObfuscate, &mStrikethrough";
        System.out.println(HexUtil.colorToMiniMessage(s1));
    }
}
