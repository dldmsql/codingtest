package com.company.programmer.level2;

public class MakeDot {

  public static void main(String[] args) {
    System.out.println(solution(2, 4));
    System.out.println(solution(1, 5));
  }
  public static long solution(int k, int d) {
    long answer = 0;
    // (1) a가 가질 수 있는 범위는 0 <= a <= d/k
    for (int i = 0; i <= d/k; i++) {
      // (2) a는 현재 인덱스에 k를 곱한 값
      long a = i * k;
      // (3) b는 (d*d - a*a*k*k) / k*k의 제곱근을 씌운 값
      long b = (long) (Math.sqrt(Math.pow(d, 2) - Math.pow(a, 2)) / k);
      // (4) 나누었을 때, 몫은 b가 될 수 있는 값이므로 b를 더하면서 +1을 한 이유는 0이 될수 있기 때문
      answer += b + 1;
    }
    return answer;
  }
  public static long solution1(int k, int d) { // 2중 for문 사용 시, 시간 초과 발생
    long answer = 0;
    for (int i = 0; i <= d; i++) {
      for (int j = 0; j <= d; j++) {
        if (Math.pow(k*i, 2) + Math.pow(k*j, 2) <= d*d) {
          answer++;
        }
      }
    }
    return answer;
  }
}
