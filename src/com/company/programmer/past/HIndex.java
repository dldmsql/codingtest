package com.company.programmer.past;

import java.util.Arrays;

public class HIndex {
  public int solution(int[] citations) {
    int answer = 0;
    /*
    * n : 발표한 논문의 개수. 죽, citations.size()
    * citations : 각 논문이 인용된 횟수가 담긴 배열
    *
    * h 중 가장 큰 값을 찾기 위해, 배열의 길이 - i로 접근.
    * 서로 맞물리도록 index 는 0부터 h는 배열의 길이 - i부터
    * */

    Arrays.sort(citations);

    for(int i =0; i < citations.length; i++) {
      int h = citations.length-i;

      if(citations[i] >= h ){
        answer = h;
        break;
      }
    }

    return answer;
  }
}
