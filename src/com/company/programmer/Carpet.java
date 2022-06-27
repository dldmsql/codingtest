package com.company.programmer;

import java.util.ArrayList;
import java.util.Arrays;

public class Carpet {

  public static void main(String[] args) {
    int[] result = solution(8,1);
    Arrays.stream(result).forEach(System.out::println);
  }
  public static int[] solution(int brown, int yellow) {
    int[] answer = new int[2];

    /*
    * 사각형 넓이 = brown * yellow
    * 넓이의 약수 중, 가로 > 세로
    * (가로 -2 )*(세로-2) = yellow
    * */

    int square = brown + yellow;

    for(int i =3; i < square; i++) {
      int j = square/i;

      if(square % i == 0 && j >= 3) {
        int row = Math.max(i,j);
        int col = Math.min(i,j);
        int tmpSquare = (col-2)*(row-2);

        if(tmpSquare == yellow) {
          answer[0] = row;
          answer[1] = col;
          return answer;
        }
      }
    }
    return answer;
  }

}
