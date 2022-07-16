package com.company.stage19;

import java.util.Scanner;
import java.util.Stack;

public class ex_10773 {

  public static void main(String[] args) {
    /*
    * 재현이가 실수를 해. 이때마다 0을 외쳐.
    * 가장 최근에 재민이가 쓴 숫자를 지웠어
    * 재민이가 적은 수의 총 합을 구하라.
    * K : 입력 값의 개수
    * K == 0 가장 최근에 쓴 숫자를 지운다.
    * else 해당 수를 쓴다.
    * 0일 경우, 지울 수 있는 수가 있음을 보장한다. -> size > 1
    * */

    Scanner sc = new Scanner(System.in);
    int K = sc.nextInt();

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < K; i++) {
      int in = sc.nextInt();
      if (in == 0) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(in);
      }
    }
    int answer = 0;
    for (Integer i : stack) {
      answer += i;
    }
    System.out.println(answer);
  }
}
