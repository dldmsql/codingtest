package com.company.stage15;

import java.util.Scanner;

public class ex_14889 {

  static int N;
  static  int[][] scores;
  static boolean[] visited;
  static int Min = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     N = sc.nextInt();
    scores = new int[N][N];
     visited = new boolean[N];

    for(int i =0; i<N; i++){
      for(int j = 0; j < N; j++) {
        scores[i][j] = sc.nextInt();
      }
    }

    combi(0,0);
    System.out.println(Min);
  }

  private static void combi(int idx, int count) {
    if(count == N/2) {
      diff();
      return;
    }
    for (int i = idx; i <N; i++) {
      if(!visited[i]){
        visited[i] = true;
        combi(i+1, count+1);
        visited[i] = false;
      }
    }
  }
  static void diff() {
    int team_start= 0;
    int team_link = 0;

    for (int i =0; i< N-1; i++) {
      for(int j = i+1; j < N; j++) {
        if(visited[i] == true && visited[j] == true) {
          team_start += scores[i][j];
          team_start += scores[j][i];
        }
        else if(visited[i] ==false && visited[j] == false) {
          team_link += scores[i][j];
          team_link += scores[j][i];
        }
      }
    }
    int val = Math.abs(team_start - team_link);

    if(val == 0) {
      System.out.println(val);
      System.exit(0);
    }
    Min = Math.min(val, Min);
  }
}
