package com.company.programmer.past;

import java.util.Arrays;

public class noneNum {

  public static void main(String[] args) {
    int[] numbers = {1,2,3,4,6,7,8,0};
    int result = solution(numbers);
    System.out.println(result);
  }
  public static int solution(int[] numbers) {
    int answer = 0;
    int[] results = new int[10]; // numbers에 0 ~ 9까지 숫자가 있다면 1을 저장한다.

    for (int i =0; i <10; i++) {
      for (Integer num : numbers ) {
        if( i == num ) {
          results[i] = 1;
          break;
        }
      }
    }

    for ( int i = 0; i < results.length; i++) {
      if ( results[i] == 0) answer += i; // 0인 값을 갖는 인덱스를 더한다.
    }
    return answer;
  }
}
