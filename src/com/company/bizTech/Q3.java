package com.company.bizTech;

import java.util.Arrays;

public class Q3 {
  public String solution(String[] registerd_list, String new_id) {
    String answer = "";

    /*
    * 모든 아이디는 S+N 형식이다.
    * S는 알파벳 소문자로 구성된 문자열로 길이는 3이상 6이하이다.
    * N은 숫자로 구성된 문자열로 길이는 0이상 6이하이다.
    * N의 길이가 0이 될 수 있다는 것은 N이 비어있는 null 문자열이 될 수도 있다는 의미이다
    * N의 길이가 1이상이면, N의 첫자리는 0이 될 수 없다.
    * 이미 홈페이지에 가비된 아이디의 목록 reigstered_list와 신규회원이 사용하기를 언하는 아이디 new_id가 있다.
    *
    * 1. new_id가 registered_list에 포함되어 있지 않다면, new_id를 추천하고 종료
    * 2. new_id가 registered_list에 포함되어 있다면,
    *   2-1. new_id를 두 개의 문자열 S와 N으로 분리
    *   2-2. 문자열 N을 10진수로 변환한 값을 n이라 한다.
    *   2-3. n에 1을 더한 값을 문자열로 변환한 값ㅇ르 N1이라 한다.
    *   2-4. new_id를 S+N1로 변경하고 1.로 돌아간다.
    *
    * 신규 회원에게 추천되는 아이디를 구하여라.
    *
    * registered_list의 길이는 1 이상 100,000 이하이다.
    * 리스트에 중복된 원소는 없다.
    *
    * 문제에서 설명된 방법을 적용하여 반환되는 아이디는 항상 S+N 형식이다.
    * 즉, 추천 아이디를 결정하는 방법을 수행하면서 N 부분 자릿수가 6을 초과하는 경우의 입력은 주어지지 않는다.
    *
    * registered_list[] = {"card", "ace13", "ace16", "banker", "ace17", "ace14"} new_id "ace15" result "ace15"
    * registered_list[] = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"} new_id = "cow" result = "cow10"
    * */

    return answer;
  }
}
