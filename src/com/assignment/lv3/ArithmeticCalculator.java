package com.assignment.lv3;

import com.assignment.lv3.Execptions.DivisionByZeroException;
import com.assignment.lv3.Execptions.InvalidOperatorException;
import com.assignment.lv3.operators.*;

import java.util.*;
import java.util.stream.Collectors;

public class ArithmeticCalculator<N extends Number> implements Comparator<N> {

    // 연산 결과를 저장하는 컬렉션 타입 필드
    private List<N> calcResult;
    private final List<AbstractOperator<N>> operators;
    private N firstNum;
    private N secondNum;
    private OperatorType operator;

    ArithmeticCalculator() {
        calcResult = new ArrayList<>();
        operators = new ArrayList<>();
        initializeOperators();
    }

    private void initializeOperators() {
        operators.add(new AddOperator<>());
        operators.add(new SubtractOperator<>());
        operators.add(new MultiplyOperator<>());
        operators.add(new DivideOperator<>());
    }

    public OperatorType getOperator() {
        return operator;
    }

    public void setOperator(OperatorType operator) {
        this.operator = operator;
    }

    public List<AbstractOperator<N>> getOperators() {
        return operators;
    }

    public List<N> getCalcResult() {
        return calcResult;
    }

    public void setCalcResult(List<N> calcResult) {
        this.calcResult = calcResult;
    }

    public N getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(N firstNum) {
        this.firstNum = firstNum;
    }

    public N getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(N secondNum) {
        this.secondNum = secondNum;
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

    // 저장된 연산 결과 중 Scanner로 입력받은 값보다 큰 결과값들을 출력
    public List<N> getResultsGreaterThan(N value) {
        return calcResult.stream()
                .filter(result -> isGreaterThan(result, value))
                .collect(Collectors.toList());
    }

    public N calculate(OperatorType operatorType) throws InvalidOperatorException, DivisionByZeroException {
        AbstractOperator<N> operator = operators.stream()
                .filter(op -> op.getType() == operatorType)
                .findFirst()
                .orElseThrow(() -> new InvalidOperatorException("Unknown operator: " + operatorType));

        return operator.operation(firstNum, secondNum);
    }

    @Override
    public int compare(N a, N b) {
        return Double.compare(a.doubleValue(), b.doubleValue());
    }

    public boolean isGreaterThan(N a, N b) {
        return compare(a, b) >= 0;
    }
}
