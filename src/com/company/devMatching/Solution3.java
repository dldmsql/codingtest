package com.company.devMatching;

public class Solution3 {
  public String solution(int n) {
    StringBuilder answer = new StringBuilder();

    String[] fixed = {"4", "1", "2"};

   int num = n;
   while(num > 0) {
     int rest = num %3;
     num /= 3;

     if(rest == 0) num--;

     answer.insert(0, fixed[rest]);
   }

    return answer.toString();
  }
}
