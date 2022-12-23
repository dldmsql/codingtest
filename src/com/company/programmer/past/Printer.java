package com.company.programmer.past;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {
  public int solution(int[] priorities, int location) {
    int answer = 0;

    PriorityQueue<Integer> queue
        = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙 기준 우선순위 큐 생성

    for(Integer i : priorities) { // 반복문 돌면서 우선순위 배열 값 저장
      queue.add(i);
    }

    while(!queue.isEmpty()) { // 큐가 빌 때까지
      for (int i = 0; i < priorities.length; i++) { // 반복문 돌면서
        if( priorities[i] == queue.peek()) { // 우선순위랑 peek 한 값이랑 같다면
          if( i == location) { // 그때의 인덱스와 내가 찾는 값의 location과 같다면
            answer++; // 위치 증가
            return answer; // 리턴
          }
          queue.poll(); // poll은 첫번째 값 반환하고 제거한다. 
          answer++; // 여기 인덱스가 아니니까, 위치 값 증가하고 다음 타자로 넘어가자
        }
      }
    }
    return -1;
  }
}
