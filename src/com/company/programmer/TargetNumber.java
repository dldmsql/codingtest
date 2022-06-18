package com.company.programmer;

public class TargetNumber {
  int answer = 0;
  public int solution(int[] numbers, int target) {

    /*
    * numbers : 숫자가 들어 있는 배열
    * target : 타겟 넘버
    * 완전 탐색 방법으로 문제 해결 ( DFS )
    * index 가 numbers.length와 같다면 ( 즉, 끝까지 탐색했다면 )
    * sum == target
    * answer++;
    * else dfs( index+1, numbers, target, sum + numbers[index] )
    *      dfs ( index +1 , numbers, target, sum - numbers[index] )
    * */

    dfs(0,numbers, target, 0);

    return answer;
  }

  private void dfs(int index, int[] numbers, int target, int sum) {
    if (index == numbers.length) {
      if (sum == target) {
        answer++;
      }
    } else {
      dfs(index+1, numbers, target, sum + numbers[index]);
      dfs(index+1, numbers, target, sum - numbers[index]);
    }
  }
}
