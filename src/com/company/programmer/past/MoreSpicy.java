package com.company.programmer.past;

import java.util.PriorityQueue;

public class MoreSpicy {
  public int solution(int[] scoville, int K) {
    int answer = 0;

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (Integer i : scoville) {
      queue.add(i);
    }

    while(queue.peek() <= K) {

       if (queue.size() < 2) {
         return -1; // answer = -1; 이걸로 하면 시간 초과 발생
       } else {
         int first = queue.poll();
         int second = queue.poll();
         int sum = first + (second*2);
         queue.add(sum);
         answer++;
       }

    }
    return answer;
  }
}
