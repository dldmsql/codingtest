package com.company.stage18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ex_1931 {

  public static void main(String[] args) {
    /*
    * 1개의 회의실
    * N개의 회의
    * 각 회의는 시작시간과 끝나는 시간이 주어진다.
    * 겹치지 않게 회의실을 사용할 수 있는 회의의 최대 개수를 찾자.
    * 단, 회의는 한 번 시작하면 중간에 중단될 수 없다.
    * 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
    *
    * N : 회의의 수
    * 회의 시작 시간 회의 끝나는 시간
    *
    * 그리디 알고리즘 적용을 위해서는 정렬을 해야 한다. 무엇을 기준으로 하지?
    * 종료 시간을 기준으로 정렬하기
    * 이전 종료시간에 대해 겹치는 것 제외하기
    * */

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] schedule = new int[N][2]; // 회의 일정 저장하는 2차원 배열


    for (int i =0; i < N; i++) {
      int start = sc.nextInt(); // 회의 시작 시간
      int end = sc.nextInt(); // 회의 종료 시간

      schedule[i][0] = start;
      schedule[i][1] = end;

    }

    Arrays.sort(schedule, new Comparator<int[]>() { // 종료 시간 기준 정렬하기 위해 오버라이딩
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[1] == o2[1]) { // 종료시간이 동일할 경우
          return o1[0] - o2[0]; // 시작시간이 더 빠른 순으로 해야 더 많은 회의를 진행할 수 있다.
        }
        return o1[1] - o2[1];
      }
    });

    int answer = 0; // 회의 개수
    int prev = 0; // 이전 회의 종료 시간

    for (int i = 0; i < N; i++) {
      if (prev <= schedule[i][0]) { // 이전 회의 종료 시간 보다 다음 회의 시작 시간이 크거나 같다면
        prev = schedule[i][1]; // 다음 회의 종료 시간으로 업데이트
        answer++; // 회의 개수 증가
      }
    }
    System.out.println(answer);
  }
}
