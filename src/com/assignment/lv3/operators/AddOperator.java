package com.assignment.lv3.operators;

import com.assignment.lv3.OperatorType;

public class AddOperator<N extends Number> extends AbstractOperator<N> {
    public AddOperator() {
        super(OperatorType.Add);
    }

    @Override
    public N operation(N a, N b) {
        return convertToN(a.doubleValue() + b.doubleValue());
    }
}
