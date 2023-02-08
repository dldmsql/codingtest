package com.company.baekjoon;

import java.util.Scanner;

public class B_11727 {

  static int[] dp;
  public static void main(String[] args) {
    /*
    * 2xn 직사각형을 1x2, 2x1, 2x2 타일로 채우는 방법의 수를 구하여라.
    *
    * 1 <= n <= 1,000
    *
    * output : 10,007로 나눈 나머지 출력
    * */

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    dp = new int[1001];
    dp[1] = 1;
    dp[2] = 3;
    for (int i = 3; i <= N; i++) {
      dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
    }
    System.out.println(dp[N]);
  }

}
