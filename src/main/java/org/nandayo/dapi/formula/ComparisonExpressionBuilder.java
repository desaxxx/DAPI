package org.nandayo.dapi.formula;

import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.operator.Operator;

/**
 * @since 1.3.4
 */
public class ComparisonExpressionBuilder extends ExpressionBuilder {
    private static final int PRECEDENCE_COMPARISON = 100;

    private static final Operator LESS_THAN = new Operator("<", 2, true, PRECEDENCE_COMPARISON) {
        @Override
        public double apply(double... doubles) {
            return doubles[0] < doubles[1] ? 1D : 0D;
        }
    };
    private static final Operator LESS_THAN_OR_EQUAL_TO = new Operator("<=", 2, true, PRECEDENCE_COMPARISON) {
        @Override
        public double apply(double... doubles) {
            return doubles[0] <= doubles[1] ? 1D : 0D;
        }
    };
    private static final Operator GREATER_THAN = new Operator(">", 2, true, PRECEDENCE_COMPARISON) {
        @Override
        public double apply(double... doubles) {
            return doubles[0] > doubles[1] ? 1D : 0D;
        }
    };
    private static final Operator GREATER_THAN_OR_EQUAL_TO = new Operator(">=", 2, true, PRECEDENCE_COMPARISON) {
        @Override
        public double apply(double... doubles) {
            return doubles[0] >= doubles[1] ? 1D : 0D;
        }
    };
    private static final Operator EQUAL_TO = new Operator("==", 2, true, PRECEDENCE_COMPARISON) {
        @Override
        public double apply(double... doubles) {
            return doubles[0] == doubles[1] ? 1D : 0D;
        }
    };
    private static final Operator IS_NOT_EQUAL_TO = new Operator("!=", 2, true, PRECEDENCE_COMPARISON) {
        @Override
        public double apply(double... doubles) {
            return doubles[0] != doubles[1] ? 1D : 0D;
        }
    };
    private static final Operator[] OPERATORS = {LESS_THAN,LESS_THAN_OR_EQUAL_TO,GREATER_THAN,GREATER_THAN_OR_EQUAL_TO,EQUAL_TO,IS_NOT_EQUAL_TO};

    public ComparisonExpressionBuilder(String expression) {
        super(expression);
        operator(OPERATORS);
    }
}
