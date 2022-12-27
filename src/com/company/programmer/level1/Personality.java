package com.company.programmer.level1;

import java.util.HashMap;

public class Personality {

  public static void main(String[] args) {
    System.out.println(solution(
        new String[]{"AN", "CF", "MJ", "RT", "NA"},
        new int[]{5, 3, 2, 7, 5}));

    System.out.println(solution(
        new String[]{"TR", "RT", "TR"},
        new int[]{7, 1, 3}
    ));
  }
  public static String solution(String[] survey, int[] choices) {
    // (1) 성격유형 반환하기 위한 변수
    StringBuilder answer = new StringBuilder();
    // (2) HashMap을 통한 K-V 형식으로 각 지표가 갖는 점수 기록
    HashMap<String, Integer> map = new HashMap<>();
    // (3) 초기 세팅으로 각 지표에 0점씩 부여
    map.put("R", 0);
    map.put("T", 0);
    map.put("C", 0);
    map.put("F", 0);
    map.put("J", 0);
    map.put("M", 0);
    map.put("A", 0);
    map.put("N", 0);
    // (4) 문항 수만큼 순회
    for (int i = 0; i < survey.length; i++) {
      // (5) 비동의/동의 선택에 따른 left와 right 구분하기
      String left = survey[i].split("")[0];
      String right = survey[i].split("")[1];
      // (6) 모르겠음을 선택할 경우,
      if (choices[i] == 4) {
        continue;
        // (7) 동의를 선택할 경우
      } else if (choices[i] >= 5) {
        // (8) right 쪽 선택이므로, map에서 기존 값에 점수 더하기
        map.put(right, map.getOrDefault(right, choices[i]-4) + (choices[i]-4));
        // (9) 비동의를 선택할 경우
      } else {
        // (10) left 쪽 선택이므로, map에서 기존 값에 점수 더하기
        map.put(left, map.getOrDefault(left, 4 - choices[i]) + (4-choices[i]));
      }
    }

    // (11) 점수가 동일할 경우 사전순으로 선택하기 때문에, 사전순으로도 앞이면서 값이 큰 경우로 비교 조건 세팅
    if ((map.get("R") >= map.get("T"))) {
      answer.append("R");
    } else {
      answer.append("T");
    }
    if (map.get("C") >= map.get("F")) {
      answer.append("C");
    } else answer.append("F");

    if (map.get("J") >= map.get("M")) {
      answer.append("J");
    } else answer.append("M");

    if (map.get("A") >= map.get("N")) {
      answer.append("A");
    } else answer.append("N");

    return answer.toString();
  }
}
