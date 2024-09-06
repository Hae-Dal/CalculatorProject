package com.example.calculator;

import java.util.ArrayList;
import java.util.HashMap;

public class ArithmeticCalculator<N extends Number> {

    // 연산 결과를 저장하는 컬렉션 타입 필드
    private ArrayList<HashMap<String, String>> calcResult = new ArrayList<>();

    public ArrayList<HashMap<String, String>> getCalcResult() {
        return calcResult;
    }

    public void setCalcResult(ArrayList<HashMap<String, String>> calcResult) {
        this.calcResult = calcResult;
    }

    public N calculate(N first, N second, OperatorType op) {
        HashMap<String, String> result = new HashMap<>();
        result.put("expr", first + String.valueOf(op) + second);
        calcResult.add(result);

        if (first instanceof Double || second instanceof Double) {
            switch (op) {
                case Add:
                    return (N) Double.valueOf(first.doubleValue() + second.doubleValue());
                case Subtract:
                    return (N) Double.valueOf(first.doubleValue() - second.doubleValue());
                case Multiply:
                    return (N) Double.valueOf(first.doubleValue() * second.doubleValue());
                case Divide:
                    if (first.doubleValue() != 0.0) {
                        return (N) Double.valueOf(first.doubleValue() / second.doubleValue());
                    } else {
                        throw new ArithmeticException("Division by zero is not allowed");
                    }
                default:
                    throw new IllegalArgumentException("Unknown operation");

            }
        } else if (first instanceof Integer || second instanceof Integer) {
            switch (op) {
                case Add:
                    return (N) Integer.valueOf(first.intValue() + second.intValue());
                case Subtract:
                    return (N) Integer.valueOf(first.intValue() - second.intValue());
                case Multiply:
                    return (N) Integer.valueOf(first.intValue() * second.intValue());
                case Divide:
                    if (first.intValue() != 0) {
                        return (N) Integer.valueOf(first.intValue() / second.intValue());
                    } else {
                        throw new ArithmeticException("Division by zero is not allowed");
                    }
                default:
                    throw new IllegalArgumentException("Unknown operation");

            }
        }
        throw new TypeNotPresentException(first.getClass().getName(), new Throwable("Type not found"));
    }
}
