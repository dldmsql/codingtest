package com.company.stage11;

import java.util.Scanner;

public class ex_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i< nums.length; i++){
            nums[i] = sc.nextInt();
        }
        int result = search(nums, n, m);
        System.out.println(result);
    }

    private static int search(int[] nums, int n, int m) {
       int result = 0;

       for( int i =0; i< n -2; i++){

           for( int j = i+1; j< n-1; j++){

               for( int k = j+1; k < n; k++ ){
                   int temp = nums[i] + nums[j] + nums[k];
                   if( m == temp ) return temp;

                   if ( result < m && temp < m) {
                       result = temp;
                   }
               }
           }
       }
       return result;
    }
}
