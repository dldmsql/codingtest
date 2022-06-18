package com.company.programmer;

public class Network {
  public int solution(int n, int[][] computers) {
    int answer = 0;
    /*
    * n : 컴퓨터의 개수
    * computers : 연결 표시
    * return : 네트워크 개수
    *
    * DFS 방식으로 문제 해결 ( boolean[] visited )
    * DFS 로 Node 탐색 후, 이게 끝나는 시점에서 다른 Node 를 for 문으로 탐색.
    * 방문 안한 Node 가 있다면, 네트워크 연결이 존재한다는 의미이기 때문에 count++
    * */

    boolean[] visited = new boolean[n];

    for (int i =0; i < n; i++) { // 모든 노드 탐색
      if(!visited[i]) { // false 라면 즉, 방문하지 않은 노드가 존재한다면
        answer++; // 네트워크 개수 증가
        dfs(i, computers, visited); // DFS 탐색
      }
    }
    return answer;
  }

  private void dfs(int node, int[][] computers, boolean[] visited) {
    visited[node] = true; // 해당 index 를 갖는 노드 방문 표시

    for(int i =0; i< computers.length; i++) { // 모든 노드 탐색
      if(!visited[i] && computers[node][i] == 1) { // false 이면서 해당 위치의 값이 1이라면
        dfs(i, computers, visited); // DFS 탐색
      }
    }
  }
}
