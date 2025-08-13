package org.nandayo.dapi;

import org.junit.jupiter.api.Test;
import org.nandayo.dapi.color.DColor;
import org.nandayo.dapi.color.StyleTranslator;
import org.nandayo.dapi.util.HexUtil;

public class TestClass {

    @Test
    void testColors() {
        String s1 = "<aqua>Aqua, <light_purple>Light purple, <dark_blue>Dark blue, <#ff00bb>Hex-1, &#cc44ffHex-2, <italic>Italic, <bold>Bold, &nUnderline, &6Orange, &rReset, &0Black, &cRed, &6Another orange, &kObfuscate, &mStrikethrough";
        System.out.println(HexUtil.colorToMiniMessage(s1));

        String customHex = "&#ffcc55Hi!";
        System.out.println(StyleTranslator.applyCustomHex(customHex));
        System.out.println(HexUtil.colorize(customHex));

        String gradientText = "<&#A1D2DB>Hellooo :></&#3342C7>";
        System.out.println(HexUtil.colorize(gradientText));
        System.out.println(HexUtil.colorToMiniMessage(gradientText));

        String gradientText2 = "<#A1D2DB>Hellooo :></#3342C7>";
        System.out.println(HexUtil.colorize(gradientText2));
        System.out.println(HexUtil.colorToMiniMessage(gradientText2));

        try {
            String g = "&#a9e871Hi!";
            System.out.println(HexUtil.colorize(g));
            DColor greenish = DColor.of("#a9e871");
            System.out.println("Greenish color: " + greenish.getColor());
        }catch (Exception e) {
            System.out.println("Problem getting the color greenish.");
        }
    }
}
