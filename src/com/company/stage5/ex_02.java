package com.company.stage5;

import java.util.Arrays;
import java.util.Scanner;

public class ex_02 { // 인터넷 참고함.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] nums = new int[9];
        for(int i = 0; i < 9; i++){
            nums[i] = Integer.parseInt(sc.nextLine());
        }
        int cnt =0;
        int max = 0;
        int index =0;

        for(int val : nums){
            cnt ++;
            if(val > max){
                max = val;
                index = cnt;
            }
        }
        System.out.print(max + "\n" + index);
    }

}
