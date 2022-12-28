package com.company.programmer.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideCard {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{10, 17}, new int[]{5, 20}));
    System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));
    System.out.println(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
  }
  public static int solution(int[] arrayA, int[] arrayB) {
    int answer = 0;

    // (1) 각 array는 오름차순 정렬이 되어 있다고 가정한다. 이때 가장 작은 최솟값을 찾는다.
    int gcdA = arrayA[0];
    int gcdB = arrayB[0];
    // (2) 배열 길이만큼 순회한다. ( 단, 0번째는 앞서 꺼냈기 때문에 1부터 시작한다. )
    for (int i =1; i < arrayA.length; i++) {
      // (3) 재귀함수를 통해 최대공약수를 찾는다.
      gcdA = divide(gcdA, arrayA[i]);
      gcdB = divide(gcdB, arrayB[i]);
    }
    // (4) 나누어지지 않는 수 찾기
    if(notDivisible(arrayB, gcdA))
      // answer와 비교했을 때 큰 값으로 갱신
      if(answer < gcdA)
        answer = gcdA;

    if(notDivisible(arrayA, gcdB))
      if(answer < gcdB)
        answer = gcdB;

    return answer;
  }
  public static boolean notDivisible(int[] arr, int num){
    // arr 배열 길이만큼 순회
    for(int n : arr)
      // 상대방 최대공약수로 나누어진다면
      if(n % num == 0)
        // 조건에 부합하지 않음
        return false;
    return true;
  }
  private static int divide(int a, int b) {
    // (1) a와 b가 주어졌을 때, b로 a가 나누어지면 b는 a의 공약수이다. 따라서 b를 반환한다.
    if (a % b == 0) return b;
    // (2) b로 a가 나누어지지 않는다면, b는 a의 공약수가 아니다. 따라서 b와 a%b의 값을 넘기면서 최대 공약수를 찾는다.
    else return divide(b, a%b);
  }


}
