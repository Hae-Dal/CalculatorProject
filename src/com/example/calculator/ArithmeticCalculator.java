package com.example.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArithmeticCalculator<N extends Number> implements Comparator<N> {

    // 연산 결과를 저장하는 컬렉션 타입 필드
    private ArrayList<N> calcResult = new ArrayList<>();

    public ArrayList<N> getCalcResult() {
        return calcResult;
    }

    public void setCalcResult(ArrayList<N> calcResult) {
        this.calcResult = calcResult;
    }

    // 연산 결과 저장 필드의 가장 첫번째 데이터 삭제
    public void deleteCalcResultFirst() {
        if (!calcResult.isEmpty()) {
            calcResult.remove(0);
        }
    }

    // 저장된 연산 결과 중 Scanner로 입력받은 값보다 큰 결과값들을 출력
    public void getScannerResult() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            N input = (N) Double.valueOf(br.readLine());

            List<N> collect = calcResult.stream()
                    .filter(i -> (isGreaterThan(i, input)))
                    .toList();

            collect.forEach(i -> System.out.print(i + " "));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public N calculate(N first, N second, OperatorType op) {

        if (first instanceof Double || second instanceof Double) {
            switch (op) {
                case Add:
                    calcResult.add((N) Double.valueOf(first.doubleValue() + second.doubleValue()));
                    return (N) Double.valueOf(first.doubleValue() + second.doubleValue());
                case Subtract:
                    calcResult.add((N) Double.valueOf(first.doubleValue() - second.doubleValue()));
                    return (N) Double.valueOf(first.doubleValue() - second.doubleValue());
                case Multiply:
                    calcResult.add((N) Double.valueOf(first.doubleValue() * second.doubleValue()));
                    return (N) Double.valueOf(first.doubleValue() * second.doubleValue());
                case Divide:
                    if (first.doubleValue() != 0.0) {
                        calcResult.add((N) Double.valueOf(first.doubleValue() / second.doubleValue()));
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
                    calcResult.add((N) Integer.valueOf(first.intValue() + second.intValue()));
                    return (N) Integer.valueOf(first.intValue() + second.intValue());
                case Subtract:
                    calcResult.add((N) Integer.valueOf(first.intValue() + second.intValue()));
                    return (N) Integer.valueOf(first.intValue() - second.intValue());
                case Multiply:
                    calcResult.add((N) Integer.valueOf(first.intValue() + second.intValue()));
                    return (N) Integer.valueOf(first.intValue() * second.intValue());
                case Divide:
                    if (first.intValue() != 0) {
                        calcResult.add((N) Integer.valueOf(first.intValue() + second.intValue()));
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

    @Override
    public int compare(N a, N b) {
        return Double.compare(a.doubleValue(), b.doubleValue());
    }

    public boolean isGreaterThan(N a, N b) {
        return compare(a, b) >= 0;
    }
}
