package com.company.programmer.level1;

public class Three {

  public static void main(String[] args) {
    /*
    * 주어진 숫자를 3진법으로 변환한 뒤, 뒤집은 숫자를 다시 10진법으로 표현해라
    * 45 -> 1200 -> 0021 -> 7
    * */
    int n = 45;
    String answer = "";
    int result = 0;
    while(n != 0) {
      answer += n%3;
      n /= 3;
    }
    result = Integer.parseInt(answer, 3);
    System.out.println("answer is " + result);
  }
}
