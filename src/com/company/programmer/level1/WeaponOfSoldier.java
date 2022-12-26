package com.company.programmer.level1;

import java.util.ArrayList;

public class WeaponOfSoldier {

  public static void main(String[] args) {
    System.out.println(solution(5, 3, 2));
  }
  public static int solution(int number, int limit, int power) {
    int answer = 0;
    // (1) number의 약수 구하기
    ArrayList<Integer> list = findNums(number);
    // (2) 각 기사단원들의 공격력과 limit 비교하기
    for (int i = 0; i < list.size(); i++) {
      // (3) 기사단원의 공격력이 limit 보다 크다면
      if (limit < list.get(i)) {
        // (4) 제시된 power 만큼 더하기
        answer += power;
        // (5) limit 보다 작거나 같다면, 본인의 공격력만큼 더하기
      } else answer += list.get(i);
    }

    return answer;
  }

  private static ArrayList<Integer> findNums(int number) {
    ArrayList<Integer> list = new ArrayList<>();
    // (1) 1 ~ number 까지의 기사단원의 공격력 구하기
    for (int i = 1; i <= number; i++) {
      // (2) 약수의 개수를 세기 위한 변수
      int count = 0;
      // (3) i번째 기사단원의 약수 구하기
      for (int j = 1; j * j <= i; j++) { // 반복문의 횟수를 줄여버리기
        if (j * j == i) {
          count++;
        }
        else if (i % j == 0) {
          count+=2;
        }
      }
      list.add(count);
    }
    return list;
  }

  private static ArrayList<Integer> findNums_timeout(int number) { // 시간초과
    ArrayList<Integer> list = new ArrayList<>();
    // (1) 1 ~ number 까지의 기사단원의 공격력 구하기
    for (int i = 1; i <= number; i++) {
      // (2) 약수의 개수를 세기 위한 변수
      int count = 0;
      // (3) i번째 기사단원의 약수 구하기
      for (int j = 1; j <= i; j++) {
        if (i % j == 0) {
          count++;
        }
      }
      list.add(count);
    }
    return list;
  }
}
