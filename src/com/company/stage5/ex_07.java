package com.company.stage5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ex_07 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCnt = Integer.parseInt(sc.nextLine());
        String[] test = new String[testCnt];
        for(int i = 0; i < testCnt; i++) {
            test[i] = sc.nextLine();
        }
        for(int i = 0; i < testCnt; i++) {
            System.out.println(String.format("%.3f",calculateAVG(test[i]))+"%");
        }
    }

    private static double calculateAVG(String tCase) {
        int stuNum = Integer.parseInt(tCase.split(" ")[0]);
        int[] cases = new int[stuNum];
        for (int i =1 ; i <stuNum+1; i++){
            cases[i-1] = Integer.parseInt(tCase.split(" ")[i]);
        }
        int avg =0;
        for (Integer val : cases){
         avg += val;
        }
        avg = avg/stuNum;
        int cnt = 0;
        for(Integer val2 : cases){
            if( val2 > avg) cnt++;
        }
        return (double)cnt/stuNum*100;
    }
}