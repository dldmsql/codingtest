package com.company.class1;

import java.util.Scanner;

public class ex_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i< n; i++) nums[i] = sc.nextInt();

        System.out.println(func2(nums));
    }

    private static int func2(int[] n) {
        int result = 0;
        for( int i = 0; i < n.length; i++ ){
            for( int j = 1; j < n.length; j++){
                if( n[i] + n[j] == 100 ) {
                    result = 1;
                    break;
                }
            }
        }
        return result;
    }
}
