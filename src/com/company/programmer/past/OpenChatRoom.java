package com.company.programmer.past;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChatRoom {

  public static void main(String[] args) {
    String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
    System.out.println(solution(record));
  }
  public static String[] solution(String[] record) {
    ArrayList<User> answer = new ArrayList<>();
    ArrayList<String> result = new ArrayList<>();
    /*
    * User ( command, userId )
    *   command에 따라 출력 문구를 다르게 해야 한다.
    *   userId를 key로 하여, nickname을 찾아야 한다.
    * HashMap<> 사용
    *   key : userId
    *   value : nickname
    *
    * */

    HashMap<String,String> userInfo = new HashMap<>(); // user 정보 저장할 hash map

    for (int i = 0; i < record.length; i++) { // 각 record 의 command, userId, nickname 분리
      String[] records = record[i].split(" ");
      String command = records[0];
      String userId = records[1];

      if (command.equals("Enter")) {
        String nickname = records[2]; // Enter | Change 에만 nickname이 존재하기 때문에 내부에 정의
        if (userInfo.get(userId) == null) { // 새로 들어온 user인지 확인
          userInfo.put(userId, nickname);
        } else { // 기존 user라면 replace로 value 업데이트
          userInfo.replace(userId, nickname);
        }
        User user = new User(command, userId); // user 객체에 command와 userId 값 저장
        answer.add(user);
      } else if (command.equals("Change")) {
        String nickname = records[2];
        userInfo.replace(userId, nickname);
      } else { // Leave 인 경우, command와 함께 문구를 출력해야 한다.
        User user = new User(command, userId);
        answer.add(user);
      }
    }

    for (User user : answer) { // User 타입의 arrayList에서 최종 결과 문구를 출력하기 위해 for문 돈다.
      if (user.command.equals("Enter"))
        result.add(userInfo.get(user.userId)+"님이 들어왔습니다.");
      else if(user.command.equals("Leave"))
        result.add(userInfo.get(user.userId)+"님이 나갔습니다.");

    }

    return result.toArray(new String[0]); // arrayList -> String[] 변환
  }

  static class User {
    private String command;
    private String userId;

    public User(String command, String userId) {
      this.command = command;
     this.userId = userId;
    }


  }
}
