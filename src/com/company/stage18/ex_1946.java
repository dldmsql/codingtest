package com.company.stage18;

import java.util.Scanner;

public class ex_1946 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt(); // 테스트 케이스 개수

    for(int i = 0; i < T; i++) { // 테스트 케이스 만큼
      int N = sc.nextInt(); // 사람 수
      int[] test1 = new int[N+1]; // 각 사람의 서류와 면접 순위를 저장할 배열
      for ( int j =0; j < N; j++) { // 사람 수만큼 반복
       test1[sc.nextInt()] = sc.nextInt(); // 서류 순위가 index. 면접 순위가 value
      }

      int result = 1; // 서류 순위가 1이면 합격률이 제일 높으니까 1부터 시작

      int start = test1[1]; // 서류 순위가 1인 사람의 면접 순위를 기준으로 둔다.

      for(int k =2; k < N+1; k++) { // 서류 순위가 2인 사람부터 N인 사람까지
        if(start > test1[k]) { // 기준 순위 보다 면접 순위가 작다면 합격이다.
          result++; // 서류 순위의 값을 증가시킨다. ( 즉, k와 동일하게 맞춘다. )
          start = test1[k]; // 면접 순위 기준을 현재 합격생으로 바꾼다.
        }
      }
      System.out.println(result); // 합격생의 서류 순위를 출력한다. ( 서류 순위가 곧 그 사람의 index )
    }
  }
}
