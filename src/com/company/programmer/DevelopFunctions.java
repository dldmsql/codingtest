package com.company.programmer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DevelopFunctions {
  public int[] solution(int[] progresses, int[] speeds) {
    /*
    *   작업 순서가 모두 다르다.
    *   배포는 순서가 정해져있다.
    *   그래서 큐 선택
    *   progresses에 들어있는 요소들을 하나씩 꺼내서 100%를 기준으로 더 해야하는 진척도를 파악한다.
    *   그리고, 그 값을 speeds로 나누어 올림 처리한다.
    *   이 값을 queue에 넣느다.
    *
    *   queue
    * */
    Queue<Integer> queue = new LinkedList<>();

    for(int i =0; i<progresses.length; i++) {
      queue.add((int) Math.ceil((100.0-progresses[i]) / speeds[i]));
    }

    List<Integer> answer = new ArrayList<>();
    while(!queue.isEmpty()) {
      int day = queue.poll(); // queue 맨 앞에 있는 값 반환 후 삭제, 단 비어 있을 경우 null 반환
      int cnt = 1; // 몇 개 배포하는 지 카운트
      while(!queue.isEmpty() && day >= queue.peek()){ // 다음 원소를 peek 했을 때, 그 값이 day 보다 작다면 day랑 같이 배포되는 애다.
        cnt++;
        queue.poll();
      }
      answer.add(cnt);
    }
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}
