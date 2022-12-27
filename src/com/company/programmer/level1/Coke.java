package com.company.programmer.level1;

public class Coke {

  public static void main(String[] args) {
//    System.out.println(solution(2, 1, 20));
    System.out.println(solution(3,2,20));
  }
  public static int solution(int a, int b, int n) { // -> b를 고려하지 않고 문제를 풀었을 땐, 실패
    int answer = 0;
    // (1) 빈 병 n개에 대해 a 보다 작으면 종료
    while (n >= a) {
      // (2) 얻은 병의 개수 구하기 ->> 빈 병 n개 중 a로 나눈 몫에 b를 곱한 만큼 콜라를 돌려 받음
      int tmp = (n/a)*b;
      // (3) n 은 a로 나눈 나머지에 얻은 병의 개수를 더한 값으로 갱신
      n = (n%a) + tmp;
      // (4) answer에는 얻은 병의 수만큼 더하기
      answer += tmp;
    }
    return answer;
  }
}
