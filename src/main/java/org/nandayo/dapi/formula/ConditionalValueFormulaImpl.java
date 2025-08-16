package org.nandayo.dapi.formula;

import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.Validate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @since 1.3.4
 */
class ConditionalValueFormulaImpl extends ValueFormulaImpl {

    private final @NotNull Type type = Type.CONDITIONAL;
    private final @NotNull List<Conditional> conditionals;
    private final @NotNull Set<String> variables;

    private ConditionalValueFormulaImpl(List<Conditional> conditionals, Set<String> variables) {
        Validate.notNull(conditionals, "Conditionals cannot be null.");
        Validate.notNull(variables, "Variables cannot be null.");

        this.conditionals = new ArrayList<>(conditionals);
        this.variables = new HashSet<>(variables);
    }


    @Override
    public @NotNull ExpressionModifier setVariable(String variable, double value) {
        return new ConditionalExpressionModifierImpl(conditionals).setVariable(variable, value);
    }

    @Override
    public double evaluate() {
        return new ConditionalExpressionModifierImpl(conditionals).evaluate();
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("conditions", conditionals.stream().map(Conditional::serialize).collect(Collectors.toList()));
        map.put("variables", variables);
        return map;
    }

    @SuppressWarnings("unchecked")
    public static ConditionalValueFormulaImpl deserialize(Map<String, Object> map) {
        Validate.notNull(map, "Map cannot be null.");
        Set<String> variables = new HashSet<>((Collection<String>) map.get("variables"));
        List<Map<String, Object>> conditions = (List<Map<String, Object>>) map.get("conditions");
        List<Conditional> conditionals = new ArrayList<>();
        for (Map<String, Object> cMap : conditions) {
            conditionals.add(Conditional.deserialize(cMap, variables));
        }
        return of(conditionals, variables);
    }

    @NotNull
    public static ConditionalValueFormulaImpl of(List<Conditional> conditionals, Set<String> variables) {
        return new ConditionalValueFormulaImpl(conditionals, variables);
    }


    private static class ConditionalExpressionModifierImpl extends ExpressionModifierImpl {

        private final @NotNull List<Conditional> conditionals;
        private ConditionalExpressionModifierImpl(List<Conditional> conditionals) {
            Validate.notNull(conditionals, "Conditionals cannot be null.");


            this.conditionals = new ArrayList<>(conditionals);
        }

        @Override
        public @NotNull ExpressionModifier setVariable(String variable, double value) {
            conditionals.forEach(expr -> {
                expr.condition().setVariable(variable, value);
                expr.formula().setVariable(variable, value);
            });
            return this;
        }

        @Override
        public double evaluate() {
            for (Conditional conditional : conditionals) {
                boolean conditionResult = conditional.condition().evaluate() != 0;
                if (conditionResult) {
                    return conditional.formula().evaluate();
                }
            }
            return Double.MAX_VALUE;
        }
    }
}