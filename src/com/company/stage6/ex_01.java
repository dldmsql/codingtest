package com.company.stage6;

import java.util.Scanner;

public class ex_01 {
    public static void main(String[] args){
        // 정수 n 개가 주어졌을 때, n개의 합을 구하는 함수를 구현하라.
    }
    private static long sum(int[] a){ // 48ms
        int sum = 0;
        for(Integer val : a){
            sum += val;
        }
        return sum;
    }
    private static long sum2(int[] a){ // 12ms
        long sum = 0;
        for(int i =0; i< a.length; i++){
            sum += a[i];
        }
        return sum;
    }
}
