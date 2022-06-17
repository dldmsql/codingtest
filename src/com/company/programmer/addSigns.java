package com.company.programmer;

public class addSigns {

  public static void main(String[] args) {
    int[] nums = {4,7,12};
    boolean[] sig = {true,false,true};
    int result = solution(nums, sig);
    System.out.println(result);
  }
  public static int solution(int[] absolutes, boolean[] signs) {
    int answer = 0;

    /*
    * absolutes : 절댓값을 차례대로 담은 배열
    * signs : 부호를 차례로 담은 불리언 배열 ( true + , false - )
    * 실제 정수들의 합을 구하라.
    * */
    for (int i =0; i < absolutes.length; i++ ) {
      if (signs[i]) {
        answer += absolutes[i];
      } else {
        answer -= absolutes[i];
      }
    }

    return answer;
  }
}
