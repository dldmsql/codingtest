package com.company.baekjoon;
import java.util.*;
public class B_11057 {

  static int[][] dp;
  public static void main(String[] args) {
    /*
    * 오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다.
    * 인접한 수가 같아도 오름차순으로 간주한다.
    * 2234, 3678, 11119
    * 수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하여라
    * 수는 0으로 시작할 수 있다.
    * 1 <= N <= 1000
    * */

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    dp = new int[N+1][10];

    for (int i =0; i < 10; i++) {
      dp[0][i] = 1; // 일의 자릿수에 0~9까지 한 번씩 차지
    }

    for(int i = 1; i <= N; i++) { // 1~N의 자릿수까지
      for(int j = 0; j <= 9; j++) { // 0 ~ 9 자릿값에 대해
        for(int k = j; k < 10; k++) { // 현재 자릿값에서 9까지
          dp[i][j] += dp[i-1][k]; // 자릿수 자릿값ㅇ에 앞선 자릿수가 가질 수 있는 자릿값을 더하기
          dp[i][j] %= 10007; // 나누기
        }
      }
    }

    System.out.println(dp[N][0]%10007); // 0번째에 들어있는 값이 곧 경우의 수이다.
  }

}
