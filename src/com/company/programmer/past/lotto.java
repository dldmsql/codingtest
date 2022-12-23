package com.company.programmer.past;

import java.util.Arrays;

public class lotto {
  public int[] solution(int[] lottos, int[] win_nums) {

    /*
     *  lottos : 민우가 갖고 있는 로또 번호
     *  win_nums: 로또 당첨 번호
     * */
    
    // 몇개가 같은 숫자인 가
    // 0이 몇개인가
    int equalsCount = 0;
    for ( int i = 0; i < win_nums.length; i++) {
      for ( int j = 0; j < lottos.length; j++) {
        if (win_nums[i]==lottos[j]) {
          equalsCount++;
        }
      }
    }

    int zeroCount = 0;
    for (Integer i : lottos) {
      if (i == 0) {
        zeroCount++;
      }
    }

    int min = equalsCount;
    int max = equalsCount + zeroCount;
    int[] answer = { Math.min(7-max,6), Math.min(7-min, 6) };
    /*
    * equalsCount : 몇 개의 숫자가 같은 가
    * zeroCount : 몇 개의 숫자가 0인 가
    *
    * min : equalsCount 가 곧 최소 당첨 가능성
    * max : equalsCount + zeroCount 가 곧 최대 당첨 가능성 (6)
    *
    * 각각의 값에 대해, 7-max 와 6 중 더 작은 값을 선택.
    * ex (1)
    * min = 2
    * max = 2 + 2
    * answer [ 3, 5 ]
    * */


    return answer;
  }
}
