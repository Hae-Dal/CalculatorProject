package com.assignment.lv2;

import java.util.ArrayList;

public class Calculator {

    // 연산 결과를 저장하는 컬렉션 타입 필드
    private ArrayList<Double> calcResult = new ArrayList<>();
    private int firstNum;
    private int secondNum;
    private char operator;

    public char getOperator() {
        return operator;
    }

    public boolean setOperator(char operator) {
        if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
            this.operator = operator;
            return true;
        } else {
            System.out.println("유효한 연산자를 입력해주세요.");
            return false;
        }
    }

    public int getSecondNum() {
        return secondNum;
    }

    public boolean setSecondNum(int secondNum) {
        if (secondNum < 0) {
            System.out.println("양의 정수 또는 0을 입력해주세요.");
            return false;
        } else {
            this.secondNum = secondNum;
            return true;
        }
    }

    public int getFirstNum() {
        return firstNum;
    }

    public boolean setFirstNum(int firstNum) {
        if (firstNum < 0) {
            System.out.println("양의 정수 또는 0을 입력해주세요.");
            return false;
        } else {
            this.firstNum = firstNum;
            return true;
        }
    }

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
            System.out.println("삭제가 완료되었습니다.");
        } else {
            System.out.println("삭제할 데이터가 없습니다.");
        }
    }

    public double calculate() {
        switch (operator) {
            case '+': {
                calcResult.add((double)firstNum + secondNum);
                return firstNum + secondNum;
            }
            case '-': {
                calcResult.add((double)firstNum - secondNum);
                return firstNum - secondNum;
            }
            case '*': {
                calcResult.add((double)firstNum * secondNum);
                return firstNum * secondNum;
            }
            case '/': {
                if (secondNum == 0) {
                    throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
                } else {
                    calcResult.add((double)firstNum / secondNum);
                    return (double) firstNum / secondNum;
                }
            }
            default: {
                throw new IllegalArgumentException("올바른 연산기호를 입력해주세요.");
            }
        }
    }
}
