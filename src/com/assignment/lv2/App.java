package com.assignment.lv2;

import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);
        String flag = null;

        do {

            System.out.println(
                    """
                    ================================================
                    1. 계산하기
                    2. 계산 기록 확인
                    3. 계산 기록 삭제
                    4. 종료
                    ================================================
                    """
            );

            flag = sc.next();

            switch (flag) {
                case "1": {
                    // 양의 정수 입력받기
                    System.out.print("첫 번째 수 : ");
                    if (!cal.setFirstNum(sc.nextInt())) {
                        continue;
                    }

                    System.out.print("두 번째 수 : ");
                    if (!cal.setSecondNum(sc.nextInt())) {
                        continue;
                    }

                    // 사칙연산 기호 입력받기
                    System.out.print("연산 기호 : ");
                    if (!cal.setOperator(sc.next().charAt(0))) {
                        continue;
                    }

                    System.out.println(cal.calculate());
                    break;
                }
                case "2": {
                    System.out.println("계산 결과");
                    System.out.println(cal.getCalcResult());
                    System.out.println("================================================");
                }
                case "3": {
                    cal.deleteCalcResultFirst();
                }
            }
        } while (!flag.equals("4"));
    }
}
