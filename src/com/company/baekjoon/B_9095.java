package com.company.baekjoon;
import java.util.*;
public class B_9095 {
  static int[] dp;
  public static void main(String[] args) {
    /*
    * 정수 4를 1,2,3의 합으로 나타내는 방법은 총 7가지가 있다.
    * 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
    * 1+1+1+1
    * 1+1+2
    * 1+2+1
    * 2+1+1
    * 2+2
    * 1+3
    * 3+1
    *
    * 정수 n이 주어졌을 때, n을 1,2,3의 합으로 나타내는 방법의 수를 구하여라
    *
    * input - 테스트 케이스의 개수 T ( 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. )
    * 정수 0 < n < 11
    *
    * */

    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    dp = new int[11];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 0; i < T; i++) {
      System.out.println(recur(sc.nextInt()));
    }


  }
  public static int recur(int N) {
    if (N==1 || N==2 || N ==3) return dp[N];
    else dp[N] = recur(N-1) + recur(N-2) + recur(N-3);
    return dp[N];
  }
}
