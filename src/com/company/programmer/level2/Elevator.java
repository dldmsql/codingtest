package com.company.programmer.level2;

public class Elevator {

  public static void main(String[] args) {
    System.out.println(solution(16));
  }
    public static int solution(int storey) {
      int answer = 0;
      String num = String.valueOf(storey);
      return recur(num, num.length() -1 , 0, 0);
    }

    private static int recur(String num, int idx, int cnt, int up) {
      if(idx < 0) {
        return cnt+up;
      }

      int n = ( num.charAt(idx) - '0' ) + up;
//      System.out.println("n ->>>"+ n);
//      System.out.println("cnt ->>>" + cnt);

      if( n == 10) {
        return recur(num, idx+1, cnt, 1);
      }
      return Math.min(recur(num, idx-1, cnt+10-n, 1), recur(num, idx-1, cnt+n, 0));
    }

}
