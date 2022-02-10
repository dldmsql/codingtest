package com.company.stage9;

import java.util.Scanner;

public class ex_06 {

    public static boolean[] pri = new boolean[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pri();
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int f_p = n/2;
            int s_p = n/2;

            while(true){
                if(!pri[f_p] && !pri[s_p]){
                    System.out.println(f_p + " " + s_p);
                    break;
                }
                f_p--;
                s_p++;
            }
        }
    }
    private static void pri(){
        pri[0]= pri[1] = true;

        for(int i = 2; i<= Math.sqrt(pri.length);i++){
            if(pri[i]){
                continue;
            }
            for(int j = i*i; j < pri.length; j += i){
                pri[j]= true;
            }
        }
    }
}
