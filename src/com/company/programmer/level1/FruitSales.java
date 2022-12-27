package com.company.programmer.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class FruitSales {

  public static void main(String[] args) {
    int[] score = new int[]{1,2,3,1,2,3,1};
    System.out.println(solution(3, 4, score));
  }
  public static int solution(int k, int m, int[] score) {
    int answer = 0;
    // (1) score 정렬하기 ( 오름차순 )
    Arrays.sort(score);

    // (2) score 배열 뒤에서부터 내려오면서
    for (int i = score.length-1; i >= 0; i--) {
      // (3) score의 길이에서 현재 인덱스를 뺀 값을 m으로 딱 맞게 나누어 떨어지면, score의 현재 인덱스 요소 값과 m을 곱한다.
      if ((score.length-i) % m == 0) answer += score[i] * m;
    }
    return answer;
  }
  /*
   * score [ 1,1,1,2,2,3,3 ]
   * i = 6, (7-6)%4 = 1
   * i = 5, (7-5)%4 = 2
   * i = 4, (7-4)%4 = 3
   * i = 3, (7-3)%4 = 0 <<- 여기서 상자 한 개가 만들어짐 score[3] = 2
   * i = 2, (7-2)%4 = 1
   * i = 1, (7-1)%4 = 2
   * */
}
