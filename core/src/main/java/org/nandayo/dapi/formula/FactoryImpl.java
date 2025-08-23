package org.nandayo.dapi.formula;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @since 1.4.0
 */
class FactoryImpl implements Factory {

    private FactoryImpl() {}

    @Override
    public @NotNull ValueFormula create(Map<String, Object> map) {
        return ValueFormulaImpl.create(map);
    }

    @Override
    public @NotNull ValueFormula createSimple(String formula, Set<String> variables) {
        return SimpleValueFormulaImpl.of(formula, variables);
    }

    @Override
    public @NotNull ValueFormula createConditional(List<Conditional> conditionals, Set<String> variables) {
        return ConditionalValueFormulaImpl.of(conditionals, variables);
    }

    @Override
    public @NotNull ValueFormula createTable(Map<Integer, Double> table) {
        return TableValueFormulaImpl.of(table);
    }

    @NotNull
    public static FactoryImpl createFactory() {
        return new FactoryImpl();
    }
}
