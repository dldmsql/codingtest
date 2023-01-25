package com.company.programmer.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class d {

  public static void main(String[] args) {
    System.out.println(solution(3, new int[]{25, 30, 15, 20}, new int[][] {{13, 21}, {18, 25}, {26, 30}}));
  }
  static HashMap<Integer, Integer> map = new HashMap<>();
  static List<Integer> takes;
  static boolean[] visited;
  public static int solution(int m, int[] temperatures, int[][] clothes) {
    int answer = 0;
    takes = new ArrayList<>();
    visited = new boolean[temperatures.length];



    return answer;
  }

  private static void dfs(int depth, int m, int[] temperatures, int[][] clothes) {
    if (depth == m) {
      return;
    }

    for (int i = 0; i < temperatures.length; i++) {

    }
  }
}
