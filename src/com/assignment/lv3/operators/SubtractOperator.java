package com.assignment.lv3.operators;

import com.assignment.lv3.OperatorType;

public class SubtractOperator<N extends Number> extends AbstractOperator<N> {
    public SubtractOperator() {
        super(OperatorType.Subtract);
    }

    @Override
    public N operation(N a, N b) {
        return convertToN(a.doubleValue() - b.doubleValue());
    }
}
