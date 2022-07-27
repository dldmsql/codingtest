package com.company.dfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex_1260 {

  static StringBuilder sb = new StringBuilder();
  static int N, M, V;
  static int[][] arr;
  static Queue<Integer> queue = new LinkedList<>(); // bfs를 위한 큐

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

     N = sc.nextInt(); // 정점 개수
     M = sc.nextInt(); // 간선 개수
     V = sc.nextInt(); // 시작 정점

     arr = new int[N+1][N+1];

    for(int i=0; i < M; i++) {
      int start = sc.nextInt(); // 출발
      int last = sc.nextInt(); // 끝
      arr[start][last] = 1;
      arr[last][start] = 1;

    }
    boolean[] checked = new boolean[N+1];
    dfs(V, checked);

    sb.append("\n");
    boolean[] checkedForBfs = new boolean[N+1];

    bfs(V, checkedForBfs);
    System.out.println(sb.toString());
  }

  private static void bfs(int k, boolean[] checkedForBfs) {
    queue.add(k); // 큐에 k를 넣는다.
    checkedForBfs[k] = true; // 방문 표시

    while(!queue.isEmpty()) { // 큐가 비어질 때까지

      k = queue.poll(); // k에 큐에서 꺼낸 요소를 대입한다.
      sb.append(k + " "); // 출력을 위해 빌더에 넣어둔다.

      for(int i =1; i < N +1; i++ ){ // 1부터 순회하면서
        if(arr[k][i] == 1&& !checkedForBfs[i]) { // k의 연결된 값이면서 아직 방문하지 않은 애라면
          queue.add(i); // 큐에 넣어준다.
          checkedForBfs[i] = true; // 방문 표시
        }
      }
    }
  }

  public static void dfs(int k, boolean[] checked) {

    checked[k] = true; // 방문 표시
    sb.append(k + " "); // 출력을 위해 빌더에 넣어둔다.

    for (int i = 0; i < N+1; i++) { // 1부터 순회하면서
      if(arr[k][i] == 1 && !checked[i]){ // k의 연결된 값이면서 아직 방문하지 않은 애라면
        dfs(i, checked); // dfs 재귀호출
      }
    }
  }


}
