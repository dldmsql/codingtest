package com.company.programmer.past;

import java.util.HashSet;

public class AddTwoNums {
  public int[] solution(int[] numbers) {
//    int[] answer = {};

    HashSet<Integer> answer = new HashSet<>();

    for ( int i =0; i < numbers.length; i++ ) {
      for ( int j = i+1; j < numbers.length; j++) {
        answer.add(numbers[i] + numbers[j]);
      }
    }
    return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
  }
}
