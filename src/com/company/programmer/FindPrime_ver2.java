package com.company.programmer;

import java.util.HashSet;
import java.util.Iterator;

public class FindPrime_ver2 { // 수정해야 함
  
  HashSet<Integer> store = new HashSet<>(); // 숫자 조합한 거 저장
  boolean[] visited = new boolean[7];
  public int solution(String numbers) {
    int answer = 0;

   for(int i =0 ;i <numbers.length(); i++) {
     dfs("", numbers, i+1);
   }

   Iterator<Integer> it = store.iterator();

   while(it.hasNext()) {
     int num = it.next();
     if(prime(num)) answer++;
   }

    return answer;
  }

  private void dfs(String combi, String numbers, int i) {
    if(combi.length() == i) {
      store.add(Integer.valueOf(combi));
    }

    for (int j = 0; j < numbers.length(); j++) {
      if(!visited[j]) {
        visited[j] = true;
        combi += numbers.charAt(j);
        dfs(numbers, combi, i);
        visited[j] = false;
        combi = combi.substring(0, combi.length()-1);
      }
    }
  }


  private boolean prime(int n) {
    if(n == 0 || n == 1) return false;
    for (int i = 2; i*i <= n; i++) {
      if(n%i == 0) return false;
    }
    return true;
  }
}
