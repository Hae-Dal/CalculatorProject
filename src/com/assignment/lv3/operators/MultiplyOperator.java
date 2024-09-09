package com.assignment.lv3.operators;

import com.assignment.lv3.OperatorType;

public class MultiplyOperator<N extends Number> extends AbstractOperator<N> {
    public MultiplyOperator() {
        super(OperatorType.Multiply);
    }

    @Override
    public N operation(N a, N b) {
        return convertToN(a.doubleValue() * b.doubleValue());
    }
}
