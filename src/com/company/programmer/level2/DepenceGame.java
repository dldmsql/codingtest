package com.company.programmer.level2;

import java.util.PriorityQueue;

public class DepenceGame {

  public static void main(String[] args) {
//    System.out.println(solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
    System.out.println(solution(2, 4, new int[]{3, 3, 3, 3}));
  }
  public static int solution(int n, int k, int[] enemy) {
    // (1) 오름차순의 우선순위 큐에 각 라운드에 쓰러뜨려야 할 적의 수 담기
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    // (2) 라운드 수만큼 순회
    for (int i = 0; i < enemy.length; i++) {
      // (3) 큐에 라운드마다 쓰러뜨려야 하는 적의 수 넣기
      queue.add(enemy[i]);

      // (4) 현재 큐의 사이즈가 무적권을 사용할 수 있는 수보다 크다면
      if (k < queue.size()) {
        // (5) 병사를 소모해서 라운드를 클리어해야 한다.
        n -= queue.poll();
      }

      // (6) 병사가 모두 소진되었다면
      if (n < 0) {
        // 현재 라운드까지 클리어한 것이므로 i를 반환
        return i;
      }
    }
    // (7) 모두 쓰러뜨렸다면, enemy 배열 길이 반환
    return enemy.length;
  }
  public static int solution1(int n, int k, int[] enemy) { // 실패
    int answer = 0;
    // (1) 적의 수만큼 라운드 진행
    for (int i = 0; i < enemy.length; i++) {
      // (2)
      if (n/2 < enemy[i] && k > 0) {
        k--;
        answer++;
      }
       else if (k==0 && n < enemy[i]) {
        break;
      }
      else {
        n -= enemy[i];
        answer++;
      }
    }
    return answer;
  }
}
