package com.company.programmer.level1;

import java.util.Arrays;

public class ShortestWord {

  public static void main(String[] args) {
    Arrays.stream(solution("sss")).forEach( n -> System.out.println(String.valueOf(n)));
  }

  public static int[] solution(String s) {
    int[] answer = new int[s.length()];

    // (1) s를 한 개의 문자로 자르기
    String[] s_arr = s.split("");

    // (2) s의 문자 길이만큼 순회하면서 비교하기
    for (int i = 0; i < s_arr.length; i++) {
      // (3) s_arr[i]의 바로 앞 문자부터 0번째까지 비교하기
      for (int j = i-1; j >= 0; j--) {
        // (4) 같은 지 비교하기
        if (s_arr[j].equals(s_arr[i])) {
          // (5) index 차이를 저장
          answer[i] = i-j;
          break;
        }
      }
      // (6) 같은 문자가 없다면
      if (answer[i] == 0) {
        answer[i] = -1;
      }
    }


    return answer;
  }
}
