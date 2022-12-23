package com.company.programmer.past;

import java.util.HashMap;

public class NonCompletedPlayer {

  public static void main(String[] args) {
   String[] paritcipant = {"mislav", "stanko", "mislav", "ana"};
    String[] completion = {"stanko", "ana", "mislav"};
    System.out.println(solution(paritcipant, completion));
  }
  public static String solution(String[] participant, String[] completion) {
    String answer = "";

    /*
    * 단 한 명의 선수만 완주하지 못함.
    * participant : 선수들 이름
    * completion : 완주한 선수 이름
    * answer : 완주하지 못한 선수 이름
    * notice !! 동명이인이 있을 수 있다.
    * */

    HashMap<String, Integer> map = new HashMap<>();

    for (String s : participant) { // 참가자 map 에 다 넣기.
      map.put(s, map.getOrDefault(s, 0) +1); // 같은 이름을 key 로 갖는 데이터가 이미 있다면, value를 반환하고, 그렇지 않다면 default가 반환된다.
    } // 중복이름이 있을 경우, value는 1씩 증가된다.

    for (String s : completion) { // 완주자 map 에 value 값을 1 빼준다.
      map.replace(s, map.get(s) -1); // 중복인 사람이 존재하지 않는다면, value는 0으로 바뀐다.
    }

    for (String s : map.keySet()) {
      if (map.get(s) != 0) { // 0이 아니라는 것은 동명이인이 존재한다는 의미이다.
        answer = s;
        break;
      }
    }

    return answer;
  }
}
