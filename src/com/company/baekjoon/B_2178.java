package com.company.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2178 {
  static boolean[][] visited;
  static int[][] maps;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0,0, -1, 1};
  static int N, M;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();

    maps = new int[N][M];
    visited = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      String[] nums = sc.next().split("");
      for(int j = 0; j < nums.length; j++) {
        maps[i][j] = Integer.parseInt(nums[j]);
      }
    }
    visited[0][0] = true; // start
    bfs(0,0);
    System.out.println(maps[N-1][M-1]);
  }
  private static void bfs(int x, int y) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {x,y});

    while(!q.isEmpty()) {
      int[] nowPoint = q.poll();
      int nowX = nowPoint[0];
      int nowY = nowPoint[1];

      for(int i = 0; i < 4; i++) {
        int nextX = nowX + dx[i];
        int nextY = nowY + dy[i];

        if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
          continue;
        }
        if(visited[nextX][nextY] || maps[nextX][nextY] == 0) {
          continue;
        }
        q.add(new int[] {nextX, nextY});
        maps[nextX][nextY] = maps[nowX][nowY] + 1;
        visited[nextX][nextY] = true;
      }
    }
  }
}
