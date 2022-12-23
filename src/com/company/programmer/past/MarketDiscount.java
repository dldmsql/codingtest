package com.company.programmer.past;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MarketDiscount {
  static public void main(String[] args) {
    String[] quizWant1 = {"banana", "apple", "rice", "pork", "pot"};
    int[] quizNum1 = {3, 2, 2, 2, 1};
    String[] quizDiscount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

    String[] quizWant2 = {"apple"};
    int[] quizNum2 = {10};
    String[] quizDiscount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

    System.out.println(solution1(quizWant1, quizNum1, quizDiscount1) == 3);
    System.out.println(solution1(quizWant2, quizNum2, quizDiscount2) == 0);
  }
  public int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;

    for( int i = 0; i < discount.length; i++) {
      List<Integer> indexForWant = new ArrayList<>();

      for ( int j = 0; j < want.length; j++) {
        if(discount[i].equals(want[j])) {
          indexForWant.add(i);
        }
      }



    }
    return answer;
  }

  public static int solution1(String[] want, int[] number, String[] discount) {
    int answer = 0;

    // want에 대한 hashmap 생성
    HashMap<String, Integer> map = new HashMap<>();

    // 원하는 제품과 그 제품의 필요 수량을 저장한다.
    for (int i = 0; i < want.length; i++) {
      map.put(want[i], number[i]);
    }

    // discount를 for문으로 10개씩만 돌면서 원하는 수량 만큼 있는지 비교하기
    for(int i =0; i<= discount.length-10; i++) {
      // 할인에 대한  hashmap 생성
      HashMap<String, Integer> dMap = new HashMap<>();
      int count = 0; // 원하는 제품과 할인 제품의 수량이 동일한지 확인한다. ( 즉, 살 수 있는 제품의 개수 )

      // 할인 제품에 대해, 현재 날짜 기준으로 10일 간 이 제품의 개수를 저장한다.
      for(int j = i; j < i + 10; j++) {
        dMap.put(discount[j], dMap.getOrDefault(discount[j], 0) + 1);
      }

      // 원하는 제품에 대해서
      for(String str : want) {
        // 제품을 key로 갖는 value 값을 비교하기
        if(map.get(str) == dMap.get(str)) {
          count++; // 수량이 동일하면 카운트 증가
        } else {
          break; // 아니면 탈출
        }
      }

      if(count == want.length) answer++; // 최종적으로 원하는 제품의 수량과 할인 제품의 수량이 동일한 것의 개수가 원하는 제품의 필요 수량과 같다면
    }
    return answer;
  }
}
