package com.example.calculator;

import java.util.HashMap;

public class Calculator {

    // 연산 결과를 저장하는 컬렉션 타입 필드
    private HashMap<Object, Double> calcResult = new HashMap<>();

    public double calc(int first, int second, char op) {
        HashMap<String, String> expr = new HashMap<>();
        expr.put("first", String.valueOf(first));
        expr.put("second", String.valueOf(second));
        expr.put("op", String.valueOf(op));

        switch (op) {
            case '+' : {
                calcResult.put(expr, (double) first + second);
                return first + second;
            }
            case '-' : {
                calcResult.put(expr, (double) first - second);
                return first - second;
            }
            case '*' : {
                calcResult.put(expr, (double) first * second);
                return first * second;
            }
            case '/' : {
                if (second == 0) {
                    throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
                } else {
                    calcResult.put(expr, (double) first / second);
                    return (double) first / second;
                }
            }
            default: {
                throw new IllegalArgumentException("올바른 연산기호를 입력해주세요.");
            }
        }
    }
}
