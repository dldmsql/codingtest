package com.company.programmer.past;

import java.util.HashMap;

public class Topping {
  public int solution(int[] topping) {
    int answer = 0;

    /*
     * 토핑 개수 기준으로 반씩 나누기
     * 토핑 최대 개수 1000개
     * */

    int[] firstType = new int[10001]; // first가 갖고 있는지 확인 용
    int[] secondType = new int[10001]; // second가 갖고 있는 지 확인 용

    int first = 0; // 갖고 있는 토핑 개수
    int second = 0; // 갖고 있는 토핑 개수

    for (int i = topping.length-1; i >= 0; i--) { // 뒤에서 부터
      if(secondType[topping[i]] == 0) { // second의 배열 중 토핑 번호에 해당하는 개수가 0이면 ( 즉, 이제 처음으로 배열에 담을 차례 )
        second++; // 토핑 개수 증가
      }
      secondType[topping[i]]++; // 겹치는 토핑이 있던 없던 증가해야 한다.
    }

    for(int i =0; i < topping.length-1; i++) { // 처음부터
      if(firstType[topping[i]] == 0) { // first의 배열 중 토핑 번호에 해당하는 값이 false라면
        firstType[topping[i]]++; // true로 바꿔주고
        first++; // 토핑 개수 증가
      }
      secondType[topping[i]]--; // second 배열에서 하나 뺏기

      if(secondType[topping[i]] == 0) { // second 배열 중 해당 토핑 번호에 해당하는 개수가 0이면 ( 즉, second가 갖고 있는 토핑의 가짓수를 빼앗아 온거다 )
        second--; // 토핑 개수 감소
      }
      if(first==second) answer++; // 둘이 개수가 동일해진 경우
    }
    return answer;
  }
}
