package com.company.stage3;

import java.util.Scanner;

public class ex_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        System.out.println(fact(t));
    }
    public static int fact(int n){
        if( n == 0 ) return n;
        else return n+ fact(n-1);

    }
}
