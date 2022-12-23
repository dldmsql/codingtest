package com.company.programmer.past;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class notice { // 신고 결과 받기

  public static void main(String[] args) {
    notice n = new notice();
    String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
    int k = 2;
    Arrays.stream(n.solution(id_list, report, k)).forEach(value -> System.out.println(value));
  }
    public int[] solution(String[] id_list, String[] report, int k) {
      /**
       * id_list : userID 문자열 배열
       * report : 각 user가 신고한 userID 정보 담긴 문자열 배열
       * k : 정지 기준이 되는 신고 횟수
       * return : 각 user 별로 처리 결과 메일을 보낸 횟수를 배열에 담기
       * */
      int[] answer = {};
      answer = new int[id_list.length];

      Map<String, HashSet<String>> sourceInfos = new HashMap<>(); // 신고한 유저, 유저가 신고한 유저
      Map<String, Integer> targetCountInfos = new HashMap<>(); // 신고받은 유저, 신고받은 횟수
      HashSet<String> reportSet = new HashSet<>(Arrays.asList(report)); // report 중복 제거

      for(String s : reportSet) {
        String[] reportStr = s.split(" ");
        String sourceUser = reportStr[0]; // 신고한 유저
        String targetUser = reportStr[1]; // 신고받은 유저
        sourceInfos.putIfAbsent(sourceUser, new HashSet<String>(){{ // 신고한유저가 존재하지 않는 다면, 유저와 타겟유저를 담은 hashset을 넣는다.
          add(targetUser);
        }});
        sourceInfos.get(sourceUser).add(targetUser); // 이미 신고한 유저가 존재한다면, 그 유저의 hashset을 불러와 타겟유저를 추가한다.
        targetCountInfos.put(targetUser, targetCountInfos.getOrDefault(targetUser, 0) +1); // 타켓유저 정보 map 에 타겟유저와 타겟유저의 값이 없다면 0 있다면 1을 더한다.
      }

      for(String targetUser : targetCountInfos.keySet()) { // 타겟 유저 정보 map의 key를 모두 불러서
        int count = targetCountInfos.get(targetUser); // 각각의 타겟 유저 마다의 카운트 횟수를 변수에 담는다.
        if( count >= k ){ // 만약, 카운트가 k보다 크거나 같다면
          for( int i = 0; i< id_list.length; i++) { // 유저 아이디 리스트를 순회하면서
            if( sourceInfos.containsKey(id_list[i]) && sourceInfos.get(id_list[i]).contains(targetUser)){ // 신고한 유저 map에서 해당 신고한 유저를 key로 갖고 있으면서 타겟유저를 value로 갖고 있다면
              answer[i]++; // 최종 출력 배열 값을 1씩 증가시킨다.
            }
          }
        }
      }

      return answer;
    }

}
