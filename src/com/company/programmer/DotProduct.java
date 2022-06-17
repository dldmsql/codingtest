package com.company.programmer;

public class DotProduct {

  public static void main(String[] args) {
    int[] a = {1,2,3,4};
    int[] b = {-3,-1,0,2};

    System.out.println(solution(a,b));
  }
  public static int solution(int[] a, int[] b) {
    int answer = 0;
    /*
    * 길이가 같은 두 1차원 정수 배열 a, b
    * a와 b의 내적을 return
    * a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1]
    * */

    int n = a.length;

    for( int i =0; i < n; i++) {
      answer += a[i]*b[i];
    }

    return answer;
  }

}
