package com.company.programmer.level1;

public class FoodFight {

  public static void main(String[] args) {
    int[] result = new int[]{1,2,2,3,3,3,0,3,3,3,2,2,1};
    int[] food = new int[]{1, 3, 4, 6};
    System.out.println(solution(food));
  }
  public static String solution(int[] food) {
    StringBuilder answer = new StringBuilder();

    for (int i = 1; i < food.length; i++) {
      for (int j = 0; j < (food[i]/2); j++) answer.append(i);
    }
    String origin = answer.toString();
    StringBuilder reverse = answer.reverse();

    return origin + '0' + reverse.toString();
  }
}
