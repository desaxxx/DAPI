package org.nandayo.dapi.formula;

import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.Validate;

import java.util.*;

/**
 * @since 1.3.4
 */
class TableValueFormulaImpl extends ValueFormulaImpl {

    private final @NotNull Type type = Type.TABLE;
    private final @NotNull Map<Integer, Double> table;

    protected TableValueFormulaImpl(Map<Integer, Double> table) {
        Validate.notNull(table, "Table cannot be null.");

        this.table = new HashMap<>(table);
    }


    @Override
    public @NotNull ExpressionModifier setVariable(String variable, double value) {
        return new TableExpressionModifierImpl(table).setVariable(variable, value);
    }

    @Override
    public double evaluate() {
        return new TableExpressionModifierImpl(table).evaluate();
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        Map<String, Double> tableMap = new HashMap<>();
        for(Map.Entry<Integer, Double> entry : table.entrySet()) {
            tableMap.put(String.valueOf(entry.getKey()), entry.getValue());
        }
        map.put("values", tableMap);
        return map;
    }

    @SuppressWarnings("unchecked")
    public static TableValueFormulaImpl deserialize(Map<String, Object> map) {
        Validate.notNull(map, "Map cannot be null.");
        Map<String, Object> tableMap = (Map<String, Object>) map.get("values");
        Map<Integer, Double> table = new HashMap<>();
        for(Map.Entry<String, Object> entry : tableMap.entrySet()) {
            try {
                table.put(Integer.parseInt(entry.getKey()), Double.parseDouble(entry.getValue().toString()));
            } catch (NumberFormatException | NullPointerException ignored) {}
        }
        return new TableValueFormulaImpl(table);
    }




    private static class TableExpressionModifierImpl extends ExpressionModifierImpl {

        private final @NotNull Map<Integer, Double> table;
        private Double value = null;
        public TableExpressionModifierImpl(Map<Integer, Double> table) {
            this.table = table;
        }

        @Override
        public @NotNull ExpressionModifier setVariable(String variable, double value) {
            this.value = value;
            return this;
        }

        @Override
        public double evaluate() {
            if(value == null) return Double.MAX_VALUE;
            for(Map.Entry<Integer, Double> entry : table.entrySet()) {
                if(entry.getKey() == (int) value.doubleValue()) {
                    return entry.getValue();
                }
            }
            return Double.MAX_VALUE;
        }
    }
}
