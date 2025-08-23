package org.nandayo.dapi.formula;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.Validate;

import java.util.*;

/**
 * @since 1.4.0
 */
class SimpleValueFormulaImpl extends ValueFormulaImpl {

    private final @NotNull Type type = Type.SIMPLE;
    private final @NotNull String formula;
    private final @NotNull Set<String> variables;
    private final @NotNull Expression expression;

    private SimpleValueFormulaImpl(String formula, Set<String> variables) {
        Validate.notNull(formula, "Formula cannot be null.");
        Validate.notNull(variables, "Variables cannot be null.");

        this.formula = formula;
        this.variables = new HashSet<>(variables);
        this.expression = new ExpressionBuilder(formula).variables(variables).build();
    }


    @Override
    @NotNull
    public ExpressionModifier setVariable(String variable, double value) {
        return new SimpleExpressionModifierImpl(expression).setVariable(variable, value);
    }

    @Override
    public double evaluate() {
        return new SimpleExpressionModifierImpl(expression).evaluate();
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("formula", formula);
        map.put("variables", variables);
        return map;
    }

    @SuppressWarnings("unchecked")
    public static SimpleValueFormulaImpl deserialize(Map<String, Object> map) {
        Validate.notNull(map, "Map cannot be null.");
        String formula = (String) map.get("formula");
        Set<String> variables = new HashSet<>((Collection<String>) map.get("variables"));
        return of(formula, variables);
    }

    @NotNull
    public static SimpleValueFormulaImpl of(String formula, Set<String> variables) {
        return new SimpleValueFormulaImpl(formula, variables);
    }


    private static class SimpleExpressionModifierImpl extends ExpressionModifierImpl {

        private final @NotNull Expression clone;
        public SimpleExpressionModifierImpl(Expression existing) {
            Validate.notNull(existing, "Expression cannot be null.");
            this.clone = new Expression(existing);
        }

        @Override
        public @NotNull ExpressionModifier setVariable(String variable, double value) {
            clone.setVariable(variable, value);
            return this;
        }

        @Override
        public double evaluate() {
            return clone.evaluate();
        }
    }
}
