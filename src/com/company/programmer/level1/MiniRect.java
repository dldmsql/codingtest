package com.company.programmer.level1;

import java.util.Collections;
import java.util.PriorityQueue;

public class MiniRect {

  public static void main(String[] args) {
    System.out.println(solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}	));
    System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}	));
  }

  public static int solution(int[][] sizes) {
    int answer = 0;
    // (1) 가장 큰 수를 추출하기 위한 우선순위 큐 정의
    PriorityQueue<Integer> row = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> col = new PriorityQueue<>(Collections.reverseOrder());

    for (int i =0; i < sizes.length; i++) {
      // (2) 가로와 세로 중 더 큰 값을 가로로 swap
      if (sizes[i][0] < sizes[i][1]) {
        int tmp = sizes[i][0];
        sizes[i][0] = sizes[i][1];
        sizes[i][1] = tmp;
      }
      // (3) 가로와 세로를 각각의 큐에 삽입
      row.add(sizes[i][0]);
      col.add(sizes[i][1]);
    }
    // (4) 가장 앞에 있는 요소를 꺼내서 곱하기
    answer = row.peek() * col.peek();
    return answer;
  }
}
