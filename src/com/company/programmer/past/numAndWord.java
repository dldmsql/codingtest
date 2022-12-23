package com.company.programmer.past;

public class numAndWord {
  public int solution(String s) {
    int answer = 0;

    /*
    * 영어 -> 숫자로 바꿔라.
    * */

   String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

   for(int i =0; i< words.length; i++) {
     if (s.contains(words[i])) {
       s = s.replace(words[i],String.valueOf(i));
     }
   }

    answer = Integer.valueOf(s);
    return answer;
  }
}
