package com.company.baekjoon;

import java.util.*;
public class B_9465 {

  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int T = sc.nextInt();
    int[][] dp, cost; // dp 와 비용을 담을 cost

    for (int i = 0; i < T; i++) {
      int n = sc.nextInt();

      dp = new int[2][n+1];
      cost = new int[2][n+1];

      for(int j=0; j <2; j++) { // 초기화
        for (int k=1; k<= n; k++) {
          cost[j][k] = sc.nextInt(); // 비용 저장
        }
      }

      // 시작점 비용을 dp에 대입
      dp[0][1] = cost[0][1];
      dp[1][1] = cost[1][1];

      for (int k=2; k <= n; k++) { // 2~N 까지 최댓값 구해서 저장
        dp[0][k] = Math.max(dp[1][k-1], dp[1][k-2]) + cost[0][k];
        dp[1][k] = Math.max(dp[0][k-1], dp[0][k-2]) + cost[1][k];
      }

      System.out.println(Math.max(dp[0][n], dp[1][n])); // 최종으로 최댓값 비교
    }

  }
}
