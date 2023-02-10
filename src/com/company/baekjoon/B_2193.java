package com.company.baekjoon;

import java.util.*;
public class B_2193 {
  static long[] dp;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    dp = new long[N+1]; // N=90 이므로 90자릿수가 되면 int의 범위를 넘어선다.
    dp[0] = 0; // n이 0이면 0
    dp[1] = 1; // n이 1이면 올 수 있는 건 1뿐이기에 1
    System.out.println(recur(N));
  }

  public static long recur(int N) {
    if(N==0 || N==1) return dp[N];
    else if(dp[N] > 0) return dp[N]; // 이미 방문한 거라면 패스! ( 얘 없으면 시간초과 )
    else dp[N] = recur(N-2) + recur(N-1); // n에 0이 오면, n-1번째에는 0혹은 1이 올 수 있기에 N-1의 경우의 수를 갖는다.
    return dp[N]; // n에 1이 올 경우, n-1에 무조건 0이 와야하고, n-2에는 0 혹은 1이 올 수 있으므로 N-2의 경우의 수를 갖는다.
  }
}
