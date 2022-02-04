package com.company.stage8;

import java.util.Scanner;

public class ex_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =0; i<t; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dis = end - start;
            int max = (int) Math.sqrt(dis);

            if(max == Math.sqrt(dis)){
                System.out.println(2*max -1);
            }
            else if (dis <= max*max + max){
                System.out.println(2*max);
            } else{
                System.out.println(2*max+ 1);
            }
        }
    }
}
