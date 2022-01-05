package com.company.stage5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ex_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        for(int i = 0; i< strs.length; i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(nums);
        System.out.print(nums[0]+ " " + nums[n-1]);
    }

}
