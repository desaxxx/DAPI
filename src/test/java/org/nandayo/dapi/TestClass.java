package org.nandayo.dapi;

import org.junit.jupiter.api.Test;
import org.nandayo.dapi.color.DColor;
import org.nandayo.dapi.color.StyleTranslator;
import org.nandayo.dapi.formula.Conditional;
import org.nandayo.dapi.formula.ValueFormula;
import org.nandayo.dapi.util.HexUtil;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    //@Test
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

    @Test
    void testFormulas() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", "simple");
        map.put("formula", "100 * level + 50");
        map.put("variables", List.of("level"));

        ValueFormula formula = ValueFormula.Factory.create(map);
        assertEquals(150d, formula.setVariable("level", 1).evaluate());
        assertEquals(250d, formula.setVariable("level", 2).evaluate());
        assertEquals(350d, formula.setVariable("level", 3).evaluate());
    }

    @Test
    void testConditionalFormula() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", "conditional");
        List<Map<String, Object>> conditions = new ArrayList<>();
        conditions.add(Conditional.of("level <= 3","level * 10", Set.of("level")).serialize());
        conditions.add(Conditional.of("level <= 5", "level * 12", Set.of("level")).serialize());
        map.put("conditions", conditions);
        map.put("variables", List.of("level"));

        ValueFormula formula = ValueFormula.Factory.create(map);
        assertEquals(10d, formula.setVariable("level", 1).evaluate());
        assertEquals(20d, formula.setVariable("level", 2).evaluate());
        assertEquals(30d, formula.setVariable("level", 3).evaluate());
        assertEquals(48d, formula.setVariable("level", 4).evaluate());
        assertEquals(60d, formula.setVariable("level", 5).evaluate());
        assertEquals(Double.MAX_VALUE, formula.setVariable("level", 6).evaluate());
    }

    @Test
    void testTableFormula() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", "table");
        Map<String, Object> values = new HashMap<>();
        values.put("1", 10);
        values.put("2", 23);
        values.put("3", 40);
        map.put("values", values);

        ValueFormula formula = ValueFormula.Factory.create(map);
        assertEquals(10d, formula.setVariable("level", 1).evaluate());
        assertEquals(23d, formula.setVariable("level", 2).evaluate());
        assertEquals(40d, formula.setVariable("level", 3).evaluate());
        assertEquals(Double.MAX_VALUE, formula.setVariable("level", 4).evaluate());
    }
}
