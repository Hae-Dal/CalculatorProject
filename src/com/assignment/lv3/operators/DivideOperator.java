package com.assignment.lv3.operators;

import com.assignment.lv3.Execptions.DivisionByZeroException;
import com.assignment.lv3.OperatorType;

public class DivideOperator<N extends Number> extends AbstractOperator <N>{
    public DivideOperator() {
        super(OperatorType.Divide);
    }

    @Override
    public N operation(N a, N b) {
        if (b.doubleValue() == 0) {
            throw new DivisionByZeroException("0으로는 나눌 수 없습니다.");
        }
        return convertToN(a.doubleValue() / b.doubleValue());
    }
}
