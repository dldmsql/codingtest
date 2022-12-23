package com.company.programmer.past;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionAsN {
  static int min = Integer.MAX_VALUE; // 출력값

  public int solution(int N, int number) {

    dfs(0, N, number, 0);

    if(min == Integer.MAX_VALUE) return -1; // 값의 변화가 없을 경우
    return min;

  }

  private void dfs(int depth, int N, int number, int current) {

    if(depth > 8) { // 8보다 클 경우, -1
      return;
    }

    if(number==current) { // 기저 조건
      min = Math.min(depth, min);
      return;
    }
    int temp = 0; // 식을 만들어 나가기 위한 공간

    for (int i = 0; i < 8; i++) { // depth 기준으로 8보다 작을 때까지
      if(depth + i < 8) { // 8보다 크면 -1을 리턴할 거니까
        temp = temp*10 + N; // 11, 22, 33 이런 식으로 늘려 나가는 거야
        dfs(depth+i+1, N, number, current+temp); // 더하기
        // 현재 depth에서 i 번째의 다음을 탐색
        dfs(depth+i+1, N, number, current-temp); // 빼기
        dfs(depth+i+1, N, number, current/temp); // 나누기
        dfs(depth+i+1, N, number, current*temp); // 곱하기
      }
    }
   }
}
