package com.example.calculator;

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