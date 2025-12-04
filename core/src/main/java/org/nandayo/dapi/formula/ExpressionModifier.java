package org.nandayo.dapi.formula;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @since 1.4.0
 */
public interface ExpressionModifier {

    @Contract(pure = true)
    @NotNull ExpressionModifier setVariable(String variable, double value);
    double evaluate();
}
