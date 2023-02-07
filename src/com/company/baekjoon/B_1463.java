package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B_1463 {
  static Integer[] dp;
  public static void main(String[] args) {
    /*
    * 문제
    * 정수 X에 사용할 수 있는 연산은 다음과 같이 3가지이다.
    * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
    * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
    * 3. 1을 뺀다.
    *
    * 정수 N이 주어졌을 때, 위와 같은 연산 3개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하라.
    *
    * 입력 1 <= N < 1000000
    * */

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    dp = new Integer[N+1];
    dp[0] = dp[1] = 0;
    System.out.println(findOne(N));
  }
  static int findOne_timeout(int N) {
    /*
    * 시간 초과가 발생하는 이유는 호출 순서 때문이다. N-1의 경우를 가장 앞에 두었기 때문에 어떤 경우이건 이 케이스를 탐색하려 한다.
    * */
    if(dp[N] == null) {
      if (N % 6 == 0) { // 6으로 나누어지는 경우
        dp[N] = Math.min(findOne_timeout(N-1), Math.min(findOne_timeout(N/3), findOne_timeout(N/2))) + 1;
      } else if ( N % 3 == 0) { // 3으로만 나누어지는 경우
        dp[N] = Math.min(findOne_timeout(N-1), findOne_timeout(N/3)) + 1;
      } else if ( N%2 == 0) { // 2로만 나누어지는 경우
        dp[N] = Math.min(findOne_timeout(N-1), findOne_timeout(N/2)) + 1;
      } else { // 그 외의 경우
        dp[N] = findOne_timeout(N-1) + 1;
      }
    }
    return dp[N];
  }
  static int findOne(int N) {
    if(dp[N] == null) {
      if (N % 6 == 0) { // 6으로 나누어지는 경우
        dp[N] = Math.min(findOne(N/3), Math.min(findOne(N/2), findOne(N-1))) + 1;
      } else if ( N % 3 == 0) { // 3으로만 나누어지는 경우
        dp[N] = Math.min(findOne(N/3), findOne(N-1)) + 1;
      } else if ( N%2 == 0) { // 2로만 나누어지는 경우
        dp[N] = Math.min(findOne(N/2), findOne(N-1)) + 1;
      } else { // 그 외의 경우
        dp[N] = findOne(N-1) + 1;
      }
    }
    return dp[N];
  }
}
