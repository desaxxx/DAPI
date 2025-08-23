package org.nandayo.dapi.formula;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

/**
 * <pre>
 * value_formula:
 *   type: simple
 *   formula: "100 + (level ^ 2) * 5"
 *   variables: [ "level" ]
 *
 * value_formula:
 *   type: conditional
 *   conditions:
 *     - condition: "level <= 10"
 *       formula: "level * 10"
 *     - condition: "level <= 50"
 *       formula: "100 + (level - 10) * 20"
 *     - condition: "true"
 *       formula: "level * 50"
 *   variables: [ "level" ]
 *
 * value_formula:
 *   type: table
 *   values:
 *     1: 90
 *     2: 100
 *     3: 110
 *     4: 125
 *     5: 150
 *     6: 175
 * </pre>
 * @since 1.4.0
 */
public interface ValueFormula extends ExpressionModifier, ConfigurationSerializable {

    static @NotNull Factory factory() {
        return ValueFormulaImpl.FACTORY;
    }

    @Override
    @NotNull ExpressionModifier setVariable(String variable, double value);

    @Override
    double evaluate();

    enum Type {
        SIMPLE,
        CONDITIONAL,
        TABLE
    }
}
