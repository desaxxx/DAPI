package org.nandayo.dapi.formula;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * <pre>
 * value_formula:
 *   type: simple
 *   mode: total
 *   formula: "100 + (level ^ 2) * 5"
 *   variables: [ "level" ]
 *
 * value_formula:
 *   type: conditional
 *   mode: per_level
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
 *   mode: per_level
 *   values:
 *     1: 90
 *     2: 100
 *     3: 110
 *     4: 125
 *     5: 150
 *     6: 175
 * </pre>
 * @since 1.3.4
 */
public interface ValueFormula extends ExpressionModifier, ConfigurationSerializable {


    interface Factory {
        @NotNull
        static ValueFormula create(Map<String, Object> map) {
            return ValueFormulaImpl.create(map);
        }
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
