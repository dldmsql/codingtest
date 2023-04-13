package com.company.programmer.level2;

import java.util.HashSet;
import java.util.Set;

public class circular {

  public static void main(String[] args) {
    int[] elements = new int[] {7,9,1,1,4};

    Set<Integer> ans = new HashSet<>();
    for(int i = 1; i<= elements.length; i++) {
      for(int j = 0; j < elements.length; j++) {
        int sum = 0;
        for(int k =0; k < i; k++) {
          if(j + k > elements.length-1) {
            sum += elements[j + k - elements.length];
          } else {
            sum += elements[j+k];
          }
        }
        ans.add(sum);
      }
    }
    System.out.println(ans.size());
  }
}
