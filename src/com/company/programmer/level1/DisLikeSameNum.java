package com.company.programmer.level1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DisLikeSameNum {
    public int[] solution(int []arr) {
      int[] answer = {};

      Stack<Integer> s = new Stack<>();
      Queue<Integer> q = new LinkedList<>();
      s.push(arr[0]);
      q.add(arr[0]);

      for(int i = 1; i < arr.length; i++) {
        if(s.peek() != arr[i]) {
          s.push(arr[i]);
          q.add(arr[i]);
        }
      }

      answer = new int[q.size()];
      int i = 0;
      while(!q.isEmpty()) {
        answer[i] = q.poll();
        i++;
      }


      return answer;
    }
  }
