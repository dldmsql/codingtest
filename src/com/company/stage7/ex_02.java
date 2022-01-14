package com.company.stage7;

import java.util.Scanner;

public class ex_02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        int[] nums = new int[cnt];
        String[] snums = input.split("");
        for(int i = 0; i< nums.length; i++){
            nums[i] = Integer.parseInt(snums[i]);
        }
        int sum =0;
        for(Integer val: nums){
            sum += val;
        }
        System.out.println(sum);
    }
}
