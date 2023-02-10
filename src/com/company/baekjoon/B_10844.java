package com.company.baekjoon;

import java.util.*;

public class B_10844 {
  static Long[][] dp;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    dp = new Long[N+1][10]; // 자릿수 자릿값(0~9)

    for (int i = 0; i < 10; i++) { // N==1일때, 자릿값에 올 수 있는 경우는 1가지
      dp[1][i] = 1L;
    }

    long result = 0; // 결과값

    for(int i =1; i <= 9; i++) {
      result += recur(N, i); // N에 대해 각 1 ~ 9까지 계산
    }

    System.out.println(result% 1000000000);
  }
  public static Long recur(int N, int val) {
    if (N==1) {
      return dp[N][val];
    }

    if (dp[N][val] == null) {
      if(val==0) {
        dp[N][val] = recur(N-1, 1);
      }
      else if(val == 9) {
        dp[N][val] = recur(N-1, 8);
      }
      else {
        dp[N][val] = recur(N-1, val-1) + recur(N-1, val+1);
      }
    }
    return dp[N][val] % 1000000000;
  }
}
