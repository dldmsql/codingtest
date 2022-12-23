package com.company.programmer.past;

import java.util.HashSet;

public class Phoneketmon {

  public static void main(String[] args) {
    int[] nums = {3,1,2,3};
    int[] nums2 = {3,3,3,2,2,4};
    System.out.println(solution(nums2));
  }
  public static int solution(int[] nums) {
    int answer = 0;

    answer = nums.length/2;

    HashSet<Integer> checked = new HashSet<>();
    for (int i =0; i < nums.length; i++) {
      checked.add(nums[i]);
    }

    if( checked.size() >= answer) return answer;
    else return checked.size();
  }
}
