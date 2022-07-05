package com.company.devMatching;

public class Solution1 {

  public static void main(String[] args) {
    System.out.println(solution(626331));
  }
  public static int solution(int num) {
    int answer = 0;
    if( num == 1 ) return answer;

    while(num != 1) {
      if( answer == 500) {
        answer = -1;
        break;
      }
      if( num %2 == 0) {
        num /= 2;
      } else {
        num = num*3 + 1;
      }
      answer++;
    }

    return answer;
  }
  private static int makeOne(int num) {
    if( num == 1) return num;

    if( num % 2 == 0 ) { // 짝수
      num /= 2;
    } else {
      num = num*3 + 1; // 홀수
    }
    return num;
  }
}
