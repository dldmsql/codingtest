package com.company.stage6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ex_03 {
    public static void main(String[] args){
        // an = a1 + (n-1)d
        // d = ( an - a1 ) / ( n-1 )
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] results = new boolean[n];
        for(int i =0; i< results.length; i++){
            results[i] = cal(i+1);
        }
        int cnt = 0;
        for(int i =1; i<= results.length; i++){
            if(results[i-1] == true) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static boolean cal(int n){
        if( n < 100) return true;
        if( n == 1000 ) return false;

        ArrayList<Integer> ns = new ArrayList<>();
        ns.add((n%100)%10);
        ns.add((n%100)/10);
        ns.add(n/100);

        // 100 <= n <= 1000
        if(ns.get(0) - ns.get(1) == ns.get(1) - ns.get(2)){
            return true;
        }
        return false;
    }
}