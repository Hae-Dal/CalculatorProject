package com.assignment.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        // LV.1 개인과제
        Scanner sc = new Scanner(System.in);
        String flag = null;

        do {
            // 양의 정수 입력받기
            System.out.print("첫 번째 수 : ");
            int first = Integer.parseInt(sc.next());
            if (first < 0) {
                System.out.println("양의 정수 또는 0을 입력해주세요.");
                continue;
            }

            System.out.print("두 번째 수 : ");
            int second = Integer.parseInt(sc.next());
            if (second < 0) {
                System.out.println("양의 정수 또는 0을 입력해주세요.");
                continue;
            }

            // 사칙연산 기호 입력받기
            System.out.print("연산 기호 : ");
            char op = sc.next().charAt(0);

            // 연산기호에 따라 연산 후 출력
            switch (op) {
                case '+' : {
                    System.out.println(first + second);
                    break;
                }
                case '-' : {
                    System.out.println(first - second);
                    break;
                }
                case '*' : {
                    System.out.println(first * second);
                    break;
                }
                case '/' : {
                    if (second == 0) {
                        System.out.println("0으로는 나눌 수 없습니다.");
                    } else {
                        System.out.println((double) first / second);
                    }

                    break;
                }
                default: {
                    System.out.println("올바른 연산기호를 입력해주세요.");
                }
            }

            System.out.println("계산기를 종료하시려면 `exit`를 입력해주세요.");

            flag = sc.next();
        } while (!(flag != null && flag.equals("exit")));
    }
}
