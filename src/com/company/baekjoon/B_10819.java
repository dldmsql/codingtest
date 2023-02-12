package com.company.baekjoon;

import java.util.Scanner;

public class B_10819 {
  static int N, answer;
  static boolean[] visited;
  static int[] arr;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    visited = new boolean[N+1]; // 방문기록
    arr = new int[N+1]; // 배열에 담기는 값

    for( int i= 0; i < N; i++) arr[i] = sc.nextInt();

    dfs(0,0,0); // 0부터 시작
    System.out.println(answer);
  }

  public static void dfs(int cnt, int bf, int sum) {
    if(cnt == N) { // N까지 방문했다면
      answer = Math.max(answer, sum); // 앞서 N-1까지 계산된 누적합과 N까지 계산된 누적합 중 최댓값 선택
      return;
    }

    for(int i =0; i < N; i++) { // N까지 순회하면서
      if(visited[i]) continue; // 방문했다면 다음으로
      visited[i] = true; // 현재 인덱스 방문 표시
      dfs(cnt+1, arr[i], cnt==0? 0 : sum+Math.abs(bf-arr[i])); // 다음 인덱스, 현재 인덱스의 값, 누적합이 0이면 0을 아니라면 앞서 계산된 누적합에 앞선 인덱스의 값에서 현재 인덱스의 값을 뺀 절댓값 더하기
      visited[i] = false; // 현재 인덱스 방문 표시 해제
    }
  }
}
