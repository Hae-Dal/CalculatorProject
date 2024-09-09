package com.assignment.lv3.operators;

import com.assignment.lv3.OperatorType;

public abstract class AbstractOperator<N> {
    protected final OperatorType type;

    protected AbstractOperator(OperatorType symbol) {
        this.type = symbol;
    }

    public abstract N operation(N a, N b);

    public OperatorType getType() {
        return type;
    }

    protected N convertToN(double value) {
        return (N) Double.valueOf(value);
    }
}
