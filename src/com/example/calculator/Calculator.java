package com.example.calculator;

import java.util.ArrayList;
import java.util.HashMap;

public class Calculator {

    // 연산 결과를 저장하는 컬렉션 타입 필드
    private ArrayList<HashMap<String, String>> calcResult = new ArrayList<>();

    public ArrayList<HashMap<String, String>> getCalcResult() {
        return calcResult;
    }

    public void setCalcResult(ArrayList<HashMap<String, String>> calcResult) {
        this.calcResult = calcResult;
    }

    public double calc(int first, int second, char op) {
        HashMap<String, String> result = new HashMap<>();
        result.put("expr", first + String.valueOf(op) + second);
        calcResult.add(result);

        switch (op) {
            case '+' : {
                result.put("result", String.valueOf((double)first + second));
                return first + second;
            }
            case '-' : {
                result.put("result", String.valueOf((double) first - second));
                return first - second;
            }
            case '*' : {
                result.put("result", String.valueOf((double) first * second));
                return first * second;
            }
            case '/' : {
                if (second == 0) {
                    throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
                } else {
                    result.put("result", String.valueOf((double) first / second));
                    return (double) first / second;
                }
            }
            default: {
                throw new IllegalArgumentException("올바른 연산기호를 입력해주세요.");
            }
        }
    }
}
