package com.company.programmer.level2;

import java.util.Arrays;

public class TableHash {

  public static void main(String[] args) {
    System.out.println(solution(
        new int[][]{{2,2,6},{1,5,10},{4,2,9},{3,8,3}},
        2,
        2,
        3));
  }
  public static int solution(int[][] data, int col, int row_begin, int row_end) {
    int answer = 0;
    // (1) 각 튜플에 대해 왼 != 오 라면, 왼 - 오 : 오 - 왼
    Arrays.sort(data, ((o1, o2) -> o1[col - 1] != o2[col - 1] ? o1[col - 1] - o2[col - 1] : o2[0] - o1[0]));
    // (2) begin ~ end 까지 순회
    for (int i = row_begin - 1; i <= row_end - 1; i++) {
      // (3) 누적합 담을 변수
      int S_i = 0;
      // (4) 각 컬럼을 i+1로 나눈 값을 더함 -> 위에서 -1 했기 때문
      for (int d : data[i]) S_i += (d % (i + 1));
      // (5) XOR(^) 누적
      answer = (answer ^ S_i);
    }

    return answer;
  }
  public static int solution_1(int[][] data, int col, int row_begin, int row_end) { // 실패
    int answer = 0;

    // (1) row 정렬하기

    for (int i = 0; i < data.length; i++) {
      for (int j = 1; j < data.length; j++) {
        if (data[i][col] > data[j][col]) { // left > right
          int[] tmp = data[i];
          data[i] = data[j];
          data[j] = tmp;
         } else if (data[i][col] == data[j][col]) {
          if (data[i][0] < data[j][0]) { // left < right
            int[] tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
          }
        }
      }
    }
    int S_begin = 0;
    int S_end = 0;
    for (int i = 0; i < data[0].length; i++) {
      S_begin += data[row_begin][i] % row_begin;
      S_end += data[row_end][i] % row_end;
    }

    if (S_begin > S_end) return S_begin;
    else return S_end;
  }
}
