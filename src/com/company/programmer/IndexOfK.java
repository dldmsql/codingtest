package com.company.programmer;

import java.util.Arrays;

public class IndexOfK {
  public int[] solution(int[] array, int[][] commands) {
    int[] answer = {};

    /*
    * array : 정렬되어 있지 않은 숫자 배열
    * commands[][] : start, end, result 순으로 담긴 배열
    * return : 각 command 에 대한 결과 값
    * 
    * copyOfRange 함수 사용
    * 인덱스 계산에 주의하자.
    * */
    for (int i =0; i< commands.length; i++) {
      int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);

      Arrays.sort(temp);
      answer[i] = temp[commands[i][2]-1];
    }
    return answer;
  }
}
