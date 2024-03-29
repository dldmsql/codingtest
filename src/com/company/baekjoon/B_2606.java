package com.company.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2606 {
  static int N,M,V;
  static boolean[] visited;
  static int[][] maps;
  static int count = 0;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();
    V = 1;

    maps = new int[N+1][N+1];
    visited = new boolean[N+1];

    for(int i = 0 ; i < M; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();

      maps[start][end] = maps[end][start] = 1;
    }

    bfs(1);
    System.out.println(count);
  }
  private static void bfs(int n) {
    Queue<Integer> q = new LinkedList<>();
    q.add(n);
    visited[n] = true;
    while(!q.isEmpty()) {
      int tmp = q.poll();

      for(int i = 1; i <= N; i++) {
        if(maps[tmp][i] == 1 && !visited[i]) {
          q.add(i);
          visited[i] = true;
          count++;
        }
      }
    }
  }
}
