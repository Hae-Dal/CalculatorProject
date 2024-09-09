package com.assignment.lv3;

public enum OperatorType {
    Add('+'),
    Subtract('-'),
    Multiply('*'),
    Divide('/');

    private final char operator;

    OperatorType(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }
}