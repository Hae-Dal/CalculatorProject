package com.example.calculator;

import java.util.ArrayList;
import java.util.HashMap;

public class ArithmeticCalculator {

    // 연산 결과를 저장하는 컬렉션 타입 필드
    private ArrayList<HashMap<String, String>> calcResult = new ArrayList<>();

    public ArrayList<HashMap<String, String>> getCalcResult() {
        return calcResult;
    }

    public void setCalcResult(ArrayList<HashMap<String, String>> calcResult) {
        this.calcResult = calcResult;
    }

    public double calc(int first, int second, OperatorType op) {
        HashMap<String, String> result = new HashMap<>();
        result.put("expr", first + String.valueOf(op) + second);
        calcResult.add(result);

        switch (op) {
            case Add:
                return first + second;
            case Subtract:
                return first - second;
            case Multiply:
                return first * second;
            case Divide:
                if (first != 0) {
                    return (double) first / second;
                } else {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
            default:
                throw new IllegalArgumentException("Unknown operation");

        }
    }
}
