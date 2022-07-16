package com.company.stage19;

import java.util.Scanner;
import java.util.Stack;

public class ex_9012 {

  public static void main(String[] args) {
    /*
    * 괄호 문자열 ( ) < -- 올바른 괄호 문자열
    * x == 올바른 괄호 문자열 -> ( x ) 도 올바른 괄호 문자열이 된다.
    * T : 테스트 개수
    * ( -> push()
    * stack.isEmpty() -> ')' 인데, 짝꿍이 없는 경우 "NO"
    * !stack.isEmpty() -> ')' 인데, 짝꿍이 있는 경우 pop()
    * 넣을 거 다 넣고, 뺄 거 다 뺀 후에 stack.isEmpty() -> "YES"
    * !stack.isEmpty() -> "NO"
    * */

    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int i =0; i < T; i++) {
      String in = sc.next();

      System.out.println(check(in));
    }
  }

  private static String check(String in) {
    Stack<Character> stack = new Stack<>();
    for (int j = 0; j < in.length(); j++ ) {
      char c = in.charAt(j);

      if(c == '(') {
        stack.push(c);
      }

      else if (stack.empty()) {
        return "NO";
      }

      else {
        stack.pop();
      }
    }

    if(stack.isEmpty()) {
      return "YES";
    } else {
      return "NO";
    }
  }
}
