package com.company.programmer.level1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LegendOfSinger {

  public static void main(String[] args) {
    int[] scores = new int[]{10, 100, 20, 150, 1, 100, 200};
    int[] result = solution(3, scores); // [10, 10, 10, 20, 20, 100, 100]
    Arrays.stream(result).forEach(System.out::println);
  }

  public static int[] solution(int k, int[] score) {
    int[] answer = new int[score.length];
    // (1) 우선순위 큐
    // 생성 낮은 숫자가 우선순위인 큐이다.
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    // (2) score의 길이만큼 순회
    for (int i =0; i < score.length; i++) {
      // (3) 큐에 점수를 넣는다.
      queue.add(score[i]);
      // (4) 큐의 사이즈가 k 보다 크다면
      if (queue.size() > k) {
        // (5) 큐의 첫번째 요소를 제거한다.
        queue.poll();
      }
      // (6) 현재 큐의 첫번째 요소를 반환한다. ( 제거하지는 않는다. )
      answer[i] = queue.peek();
    }

    return answer;
  }
}
