package com.company.baekjoon;

import java.util.*;
public class B_2156 {
  static Integer[] dp;
  static int[] amount;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    dp = new Integer[N+1];
    amount = new int[N+1];

    for (int i = 1; i < N+1; i++) {
      amount[i] = sc.nextInt();
    }
    dp[0] = 0;
    dp[1] = amount[1];

    if(N>1) { // 2인 경우에는 무조건 1+2 의 경우
      dp[2] = amount[1] + amount[2];
    }

    System.out.println(recur(N));
  }

  public static int recur(int N) {
    if(dp[N] == null) {
      dp[N] = Math.max(Math.max(recur(N - 2), recur(N - 3) + amount[N - 1]) + amount[N], recur(N - 1));
    }

    return dp[N];
  }
}
