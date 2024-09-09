package com.example.calculator;

import java.util.ArrayList;

public class Calculator {

    // 연산 결과를 저장하는 컬렉션 타입 필드
    private ArrayList<Double> calcResult = new ArrayList<>();

    public ArrayList<Double> getCalcResult() {
        return calcResult;
    }

    public void setCalcResult(ArrayList<Double> calcResult) {
        this.calcResult = calcResult;
    }

    // 연산 결과 저장 필드의 가장 첫번째 데이터 삭제
    public void deleteCalcResultFirst() {
        if (!calcResult.isEmpty()) {
            calcResult.remove(0);
        }
    }

    public double calc(int first, int second, OperatorType op) {

        switch (op) {
            case Add: {
                calcResult.add((double)first + second);
                return first + second;
            }
            case Subtract: {
                calcResult.add((double)first - second);
                return first - second;
            }
            case Multiply: {
                calcResult.add((double)first * second);
                return first * second;
            }
            case Divide: {
                if (second == 0) {
                    throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
                } else {
                    calcResult.add((double)first / second);
                    return (double) first / second;
                }
            }
            default: {
                throw new IllegalArgumentException("올바른 연산기호를 입력해주세요.");
            }
        }
    }
}
