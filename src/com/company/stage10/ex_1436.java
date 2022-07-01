package com.company.stage10;

import java.util.Scanner;

public class ex_1436 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 자릿수

    int num = 666; 
    int count = 1; // 같은지 확인용

    while(count != N) { // 카운트가 자릿수와 같을 때까지
      num++; // 숫자 증가

      if(String.valueOf(num).contains("666")) { // string으로 변경해서 666 포함 여부 확인
        count++;
      }
    }

    System.out.println(num);
  }

}
