package com.company.programmer;

import java.util.Arrays;

public class ChangeWord {

  public static void main(String[] args) {
    ChangeWord c = new ChangeWord();
    String begin = "hit";
    String target = "cog";
    String[] words = {"hot","dot","dog","lot","log","cog"};
    int result = c.solution(begin, target, words);
    System.out.println(result);
  }
  private int answer;
  private boolean[] visited;
  public int solution(String begin, String target, String[] words) {
    /*
    *   begin : 시작 단어
    *   target : 최종 단어
    *   words : 단어 배열
    *   return : 변환 과정의 최소 단계 수 ( words에 없는 target인 경우, 0 )
    *
    *   DFS로 해결해보자!
    *
    * */
    answer = 51;
    int N = words.length; // 단어 배열 길이
    visited = new boolean[N]; // 방문 확인용 boolean 배열

    dfs(words, begin, target, 0); // DFS 호출 ( count 는 최소 경우의 수 )
    return answer == 51 ? 0 : answer;
  }

  private void dfs(String[] words, String begin, String target, int count) {
    if (begin.equals(target)) { // 타겟에 도달했을 경우
        answer = Math.min(answer, count);
        return;
    }

    for (int i =0; i< words.length; i++) { // 모든 단어 배열 탐색
      if (!visited[i] && check(begin, words[i])) { // 1개의 알파벳을 제외하고 전부 같다면
          visited[i] = true; // 방문 표시
          dfs(words, begin, target, count + 1); // DFS 탐색
          visited[i] = false; // 방문 표시 해제
        }
      }
    }

  private boolean check(String begin, String target) {
    int k = 0; // 알파벳이 겹치는 개수
    for (int j = 0; j < begin.length(); j++) { // begin 기준으로 단어 쪼개서 for 문 돌린다.
      if (begin.charAt(j) != target.charAt(j)) { // begin 쪼개서 words[i] 랑 비교하기
        k++; // 같으면 카운트 증가
      }
    }
    return k == 1 ? true : false;
  }

}
