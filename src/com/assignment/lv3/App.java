package com.assignment.lv3;

import com.assignment.lv3.Execptions.DivisionByZeroException;
import com.assignment.lv3.Execptions.InvalidOperatorException;

import java.util.List;
import java.util.Scanner;

import static com.assignment.lv3.OperatorType.*;

public class App {

    public static void main(String[] args) {
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(
                        """
                        ================================================
                        1. 계산하기
                        2. 계산 결과 확인
                        3. 계산 결과 중 입력한 답보다 큰 수 확인
                        4. 계산 결과의 첫번째 데이터 삭제
                        5. 종료
                        ================================================
                        """
                );

                switch (scanner.nextLine()) {
                    case "1" : {
                        System.out.print("첫 번째 수를 입력해주세요 : ");
                        calculator.setFirstNum(Double.parseDouble(scanner.nextLine()));

                        System.out.print("두 번째 수를 입력해주세요 : ");
                        calculator.setSecondNum(Double.parseDouble(scanner.nextLine()));

                        System.out.print("연산자를 입력해주세요 (+, -, *, /): ");
                        String op = scanner.nextLine();

                        OperatorType operatorType = switch (op) {
                            case "+" -> Add;
                            case "-" -> Subtract;
                            case "*" -> Multiply;
                            case "/" -> Divide;
                            default -> throw new InvalidOperatorException("유효하지 않은 연산자: " + op);
                        };

                        Double result = calculator.calculate(operatorType);
                        List<Double> results = calculator.getCalcResult();
                        results.add(result);
                        calculator.setCalcResult(results);
                        System.out.println("답 : " + result);
                        break;
                    }
                    case "2" : {
                        System.out.println("계산 기록 : " + calculator.getCalcResult());
                        break;
                    }
                    case "3" : {
                        System.out.print("수를 입력해주세요 : ");
                        double filterValue = Double.parseDouble(scanner.nextLine());
                        List<Double> filteredResults = calculator.getResultsGreaterThan(filterValue);
                        System.out.println("기록된 답 중 입력한 수보다 큰 수 : " + filteredResults);
                        break;
                    }
                    case "4" : {
                        calculator.deleteCalcResultFirst();
                    }
                    case "5" : {
                        scanner.close();
                        System.exit(0);
                    }
                    default : {
                        throw new NumberFormatException();
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("잘못된 숫자형식입니다. 다시 시도해주세요.");
            } catch (InvalidOperatorException e) {
                System.out.println("잘못된 연산자 입니다. 다시 시도해주세요.");
            } catch (DivisionByZeroException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }


}
