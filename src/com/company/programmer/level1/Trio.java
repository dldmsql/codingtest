package com.company.programmer.level1;

public class Trio {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{-2, 3, 0, 2, -5}));
  }
  public static int solution(int[] number) {
    int answer = 0;
    // (1) 삼중 for문으로 3명의 학생의 번호를 더한 값이 0인지 확인하기
    for (int i = 0; i < number.length; i++) {
      for (int j = i+1; j < number.length; j++) {
        for (int k = j+1; k < number.length; k++) {
          if (number[i] + number[j] + number[k] == 0) {
            answer++;
          }
        }
      }
    }
    return answer;
  }
}
