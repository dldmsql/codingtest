package com.company.programmer.past;

import java.util.HashMap;

public class ListOfPhoneNum {

  public static void main(String[] args) {
    String[] nums = {"12","123","1235","567","88"};
    String[] trueNums = {"123","456","789"};
    System.out.println(solution(nums));
    System.out.println(solution(trueNums));
  }
  public static boolean solution(String[] phone_book) {
    boolean answer = true;

    /*
    * 접두어가 있으면 false, 없으면 true
    * */

    HashMap<String, Integer> map = new HashMap<>();

    for (String s : phone_book) {
      map.put(s, map.getOrDefault(s, 0) +1);
    }

    for ( String s : phone_book) { // phone 하나에 대하여
      for (int i = 0; i < s.length(); i++) { // 문자의 길이만큼 반목을 돌린다.
        if (map.containsKey(s.substring(0,i))) { // 첫글자부터 문자의 길이까지 잘라낼 떄, key랑 일치하는 값이 있는가
          answer = false; // 있다면
        }
      }

    }

    return answer;
  }
}
