package com.company.stage10;

import java.util.Scanner;

public class ex_7568 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());

    int[][] in = new int[N][2];
    for (int i=0; i< N; i++) {
      String user = sc.nextLine();
      int weight = Integer.parseInt(user.split(" ")[0]);
      int height = Integer.parseInt(user.split(" ")[1]);
      in[i][0] = weight;
      in[i][1] = height;
    }

    for(int i = 0; i< N; i++) {
      int k = 1;
      for(int j =0; j < N; j++) {
        if(i==j) continue;
        if(in[i][0] < in[j][0] && in[i][1] < in[j][1]) {
          k++;
        }
      }
      System.out.println(k + " ");
    }
  }
}
