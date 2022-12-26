package com.company.programmer.level1;

public class SplitWords {

  public static void main(String[] args) {
    System.out.println(solution("banana"));
  }
  public static int solution(String s) {
    int answer = 0; // 나누어진 문자의 개수
    char first = s.charAt(0); // 주어진 문자열의 첫번째 문자
    int firstCnt = 0; // 왼->오 가면서 같은 문자의 개수
    int restCnt = 0; // 왼->오 가면서 다른 문자의 개수

    for (int i = 0; i < s.length(); i++) { // 문자열의 길이만큼 순회
      if (firstCnt == restCnt) { // cnt의 개수가 같다면
        answer++; // 문자열 자르고, 카운트 증가
        first = s.charAt(i); // first를 다음 문자로
      }
      if (first == s.charAt(i)) { // first와 현재 문자가 같다면
        firstCnt++; // 왼->오 가면서 같은 문자이니, 증가
      } else restCnt++; // 왼->오 가면서 다른 문자이니, 증가
    }
    return answer;
  }
}
