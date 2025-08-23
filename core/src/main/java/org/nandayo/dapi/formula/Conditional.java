package org.nandayo.dapi.formula;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.Validate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @since 1.4.0
 */
public interface Conditional extends ConfigurationSerializable {

    @NotNull Expression condition();
    @NotNull Expression formula();
    @Override
    @NotNull Map<String, Object> serialize();

    @NotNull
    static Conditional of(String conditionExpression, String formulaExpression, Set<String> variables) {
        Validate.notNull(conditionExpression, "Condition expression cannot be null.");
        Validate.notNull(formulaExpression, "Formula expression cannot be null.");

        Expression condition = new ComparisonExpressionBuilder(conditionExpression).variables(variables).build();
        Expression formula = new ExpressionBuilder(formulaExpression).variables(variables).build();
        return new Conditional() {
            @Override
            public @NotNull Expression condition() {
                return condition;
            }

            @Override
            public @NotNull Expression formula() {
                return formula;
            }

            @Override
            public @NotNull Map<String, Object> serialize() {
                Map<String, Object> map = new HashMap<>();
                map.put("condition", conditionExpression);
                map.put("formula", formulaExpression);
                return map;
            }
        };
    }

    @NotNull
    static Conditional deserialize(Map<String, Object> map, Set<String> variables) {
        Validate.notNull(map, "Conditional map cannot be null.");
        String conditionExpression = (String) map.get("condition");
        String formulaExpression = (String) map.get("formula");
        return of(conditionExpression, formulaExpression, variables);
    }
}
