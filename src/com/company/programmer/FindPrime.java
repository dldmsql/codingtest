package com.company.programmer;

import java.util.HashSet;
import java.util.Iterator;

public class FindPrime {
  
  HashSet<Integer> store = new HashSet<>(); // 숫자 조합한 거 저장
  public int solution(String numbers) {
    int answer = 0;

    recursive("", numbers);

    Iterator<Integer> it = store.iterator();
    while(it.hasNext()) {
      int number = it.next();
      if(prime(number)) {
        answer++;
      }
    }
    return answer;
  }

  private void recursive(String combi, String others) {
    if(!combi.equals("")) {
      store.add(Integer.valueOf(combi));
    }

    for(int i =0; i < others.length(); i++) {
      recursive(combi + others.charAt(i), others.substring(0, i) + others.substring(i+1));
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
