package org.nandayo.dapi.formula;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @since 1.3.4
 */
@SuppressWarnings("unused")
public interface Factory {

    @NotNull ValueFormula create(Map<String, Object> map);

    @NotNull ValueFormula createSimple(String formula, Set<String> variables);
    @NotNull ValueFormula createConditional(List<Conditional> conditionals, Set<String> variables);
    @NotNull ValueFormula createTable(Map<Integer, Double> table);
}
