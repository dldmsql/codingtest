package com.company.programmer.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PairOfNum {

  public static void main(String[] args) {
//    System.out.println(solution("100", "2345"));
//    System.out.println(solution("100", "123450"));
    System.out.println(solution("12321",	"42531"));
  }

  public static String solution(String X, String Y) { // 런타임에러와 시간초과가 나서 실패했던 문제이다. 문제의 조건 파악 잘하기.

    // (1) X,Y를 숫자형으로 변환해서 담기 위한 배열 생성 ( 문제에서 k는 0부터 9까지라고 정의했다. )
    int[] numX = new int[10];
    int[] numY = new int[10];

    // (2) 반복문 순회하면서, 자른 문자가 해당하는 인덱스의 값을 증가시킨다. -> 이는 해당 인덱스를 문자열이 몇 개 갖고 있는지 카운팅하는 것이다.
    for (String x : X.split("")) numX[Integer.parseInt(x)]++;
    for (String y : Y.split("")) numY[Integer.parseInt(y)]++;

    // (3) 결과 반환하기 위한 변수
    StringBuilder answer = new StringBuilder();

    // (4) 9부터 0까지 역순회하면서 -> 이는 큰 수부터 출력하기 위함이다.
    for (int i = 9; i >=0; i--) {
      // (5) 각 숫자 배열에 담긴 개수가 같으면서 0보다 클 때
      while (numX[i] > 0 && numY[i] > 0) {
        // (6) answer에 담기
        answer.append(i);
        // (7) 담았으니 숫자 배열에서는 제거
        numX[i]--;
        numY[i]--;
      }
    }

    // (8) 만약 담긴 게 없다면, -1 반환
    if (answer.toString().length() == 0) {
      return "-1";
      // (9) 만약 담긴 값이 0으로 시작한다면, 0 반환
    } else if (answer.toString().startsWith("0")) {
      return "0";
    }

    return answer.toString();
  }
}
