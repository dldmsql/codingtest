package com.company.programmer.level1;

public class StringCount {

  public static void main(String[] args) {
    System.out.println(solution("3141592", "271"));
  }
  public static int solution(String t, String p) {
    int answer = 0;

    // (1) p의 문자열 길이 구하기
    int p_length = p.length();

    // (2) t를 p_length 만큼 잘랐을 때, 나올 수 있는 경우의 수 구하기
    int t_count = t.length() - p_length + 1;

    // (3) p의 숫자형 변수 선언하기 -> int로 선언했을 때, 런타임 에러 발생 ( 문제 조건에 p의 길이가 최대 18자리까지였다. 따라서 long으로 변경 )
    Long pNum = Long.parseLong(p);

    // (4) t_count 만큼 순회하면서, 숫자 크기 비교하기
    for (int i = 0; i < t_count; i++) {
      Long sliced = Long.parseLong(t.substring(i, i + p_length));
      System.out.println(sliced);
      if (pNum >= sliced) {
        answer++;
      }
    }
    return answer;
  }
}
