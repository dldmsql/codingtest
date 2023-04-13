package com.company.baekjoon;

import java.util.Scanner;

public class B_12865 {

  static int[] w,v; // 무게와 가치를 담는 배열
  static int[][] dp; // 무게에 따른 가치를 담은 배열
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 4
    int K = sc.nextInt(); // 7

    w = new int[N+1];
    v = new int[N+1];
    dp = new int[N+1][K+1];

    for(int i =1 ; i <= N; i++) { // 인덱스 계산의 편의를 위해 1부터 시작
      w[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= K; j++) { // 무게가 1부터 K까지 ( 최대 무게가 K이기 때문 )
        dp[i][j] = dp[i-1][j]; // 기본으로 이전 무게를 세팅
        if(j - w[i] >= 0) { // 현재 탐색 중인 J ( 무게 )에서 i번째 아이템의 무게를 차감했을 때, 양수이면
          dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]); // 이전 무게와 j-w[i] 를 했을 때의 가치를 더한 값 중 큰 값을 선택
        }
      }
    }
    System.out.println(dp[N][K]); // 최대 무게에 도달했을 때의 가치 출력
  }

}
