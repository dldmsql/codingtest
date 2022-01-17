package com.company.stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        int nA = a/100 + (a%100 - (a%100)%10) + (a%100)%10*100;
        int nB = b/100 + (b%100 - (b%100)%10) + (b%100)%10*100;

        if( nA > nB ) System.out.println(nA);
        else System.out.println(nB);
    }
}
