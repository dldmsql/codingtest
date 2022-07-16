package com.company.stage18;

import java.util.Scanner;

public class ex_11047 {

  public static void main(String[] args) {
    /*
    * N : 동전의 종류
    * 동전을 조합하여 합한 값 : K
    * 필요한 동전 개수의 최소값 구하기
    *
    * 그리디 알고리즘 적용하기 - 각 단계별로 최선의 선택지를 선택하는 것
    *   최적해를 100% 보장하진 않지만 각 순간별 최적 선택을 하기 때문에 근사 해를 구하는 속도가 빠르다.
    * */

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    int[] coins = new int[N];
    for (int i =0; i < N; i++) {
      coins[i] = sc.nextInt();
    }

    int answer = 0;

    for(int i = N-1; i >= 0; i--) { // 큰 동전부터 탐색해야 하니까
      if( coins[i] <= K) { // 현재 동전이 K보다 작거나 같다면 선택해야 하니까
        answer += ( K / coins[i] ); // 현재 동전을 선택할 수 있는 개수를 더해준다.
        K = K % coins[i]; // 나머지값으로 K 갱신
      }
    }
    System.out.println(answer);
  }
}
