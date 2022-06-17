package com.company.programmer;

import java.util.HashMap;
import java.util.Set;

public class Spy {
  String[][] clothes = {
      {"yellowhat", "headgear"},
      {"bluesunglasses", "eyewear"},
      {"green_turban", "headgear"}
  };
  public int solution(String[][] clothes) {
    int answer = 1; // 곱셈 연산을 위해 0 -> 1로 변경
    /*
    * clothes : 스파이가 가진 의상들 [ 의상 이름, 의상 종류 ]
    * 이름 중복 허용 x
    * return : 서로 다른 옷의 조합의 수
    * N개 중, 중복 없이 고르기
    * */

    HashMap<String, Integer> map = new HashMap<>(); // key : 종류, value : 개수

    for (int i =0; i < clothes.length; i++) {
      map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) +1);
    }

    /*
    * 모자 : 2개
    * 안경 : 1개
    * ---------
    * ( 2 + 1 ) * ( 1 + 1 ) -1 = 경우의 수
    *  모두 선택하지 않았을 경우인 1을 빼준다.
    * */

    for (String key : map.keySet()) {
      answer *= map.get(key)+1;
    }
    return answer-1;
  }

}
