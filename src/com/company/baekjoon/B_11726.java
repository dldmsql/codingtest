package com.company.baekjoon;

import java.util.Scanner;

public class B_11726 {
  static Integer[] dp;
  public static void main(String[] args) {
    /*
    * 2xN 크기의 직사각형을 1x2, 2x1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
    *
    * 예: N=2, output = 2
    *
    * 나올 수 있는 경우를 추린 뒤, 조합 공식으로 개수 카운트
    *
    *
    * 시간 초과 발생 : Top-down 방식으로 풀이하던 중, dp[N]에 값을 메모할 때마다 10007로 나눈 나머지 값을 넣었어야 했다.
    * */

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    dp = new Integer[N+1];
    dp[0] = dp[1] = 1;
    System.out.println(recur(N));
  }

  public static int recur(int N) {
    if (dp[N] != null) return dp[N];
    else dp[N] = (recur(N-1) + recur(N-2) ) %10007;
    return dp[N];
  }
}
