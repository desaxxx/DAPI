package org.nandayo.dapi.formula;

import org.jetbrains.annotations.NotNull;

/**
 * @since 1.3.4
 */
public interface ExpressionModifier {

    @NotNull ExpressionModifier setVariable(String variable, double value);
    double evaluate();
}
