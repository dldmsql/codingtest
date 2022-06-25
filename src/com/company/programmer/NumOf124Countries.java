package com.company.programmer;

public class NumOf124Countries {
  public String solution(int n) {
    StringBuilder answer = new StringBuilder();
    String[] indexOf124 = {"4", "1", "2"};
    /*
    * index로 접근해야 한다.
    * 3을 주기로 index를 보자.
    * 1%3 = 1 -> 1
    * 2%3 = 2 -> 2
    * 3%3 = 0 -> 4
    * [ 10진수 Index ] % 3 = [ 124 Index ] -> value
    *
    * num이 3의 배수라면, num-- 처리를 해준다.
    * */

    int num = n;

    while(num > 0) {
      int rest = num %3;
      num /= 3;

      if(rest == 0) num--;

      answer.insert(0, indexOf124[rest]); // 항상 0번째 위치에 값을 넣는다.
    }
    return answer.toString();
  }
}
