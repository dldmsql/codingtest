package com.company.programmer;

import java.util.ArrayList;
import java.util.Arrays;

public class PreTest { // 해결 못함
  public int[] solution(int[] answers) {
    int[] user1 = {1,2,3,4,5};
    int[] user2 = {2,1,2,3,2,4,2,5};
    int[] user3 = {3,3,1,1,2,2,4,4,5,5};
    int[] score = new int[3];
    /*
    * user1 : 1,2,3,4,5,1,2,3, ...
    * user2 : 2,1,2,3,2,4,2,5,2,1,...
    * user3 : 3,3,1,1,2,2,4,4,5,5,3,3,...
    * 
    * answers[] : 정답이 있는 배열
    * return[] : 정답자
    * */

    for (int i =0; i<answers.length; i++) {
      if (answers[i] == user1[i%user1.length]) score[0]++;
      if (answers[i] == user2[i%user2.length]) score[1]++;
      if (answers[i] == user3[i%user3.length]) score[2]++;
    }
    int max = Math.max(score[0], Math.max(score[1], score[2]));

    ArrayList<Integer> list = new ArrayList<>();
    if (max == score[0]) list.add(1);
    if (max == score[1]) list.add(2);
    if (max == score[2]) list.add(3);

    return list.stream().mapToInt(i -> i.intValue()).toArray();
  }

}
