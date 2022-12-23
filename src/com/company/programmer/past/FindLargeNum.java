package com.company.programmer.past;

import java.util.Arrays;

public class FindLargeNum {

  public String solution(int[] numbers) {
    StringBuilder answer = new StringBuilder();

    /*
    * 0 혹은 양의 정수가 주어질 때,
    * 이어 붙여서 가장 큰 수를 찾아라.
    * */
    String[] numberToString = new String[numbers.length]; // int[] -> String[]
    for ( int i = 0; i < numbers.length; i++) {
      numberToString[i] = String.valueOf(numbers[i]);
    }
    Arrays.sort(numberToString, (o1, o2) -> (o2+o1).compareTo(o1+o2)); // sorting with compareTo()

    if(numberToString[0].equals("0")) return "0"; // 만약 0번째 값이 0이면, 0으로 return

    for (String s : numberToString) { // 가장 큰 숫자부터 꺼내서 append
      answer.append(s);
    }
    return answer.toString();
  }


}
