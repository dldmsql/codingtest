package com.company.stage3;

import java.util.Scanner;

public class ex_11 {
    // 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때 A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        String t = sc.nextLine();
        String[] ts = t.split(" ");
        int t1 = Integer.parseInt(ts[0]);
        int t2 = Integer.parseInt(ts[1]);

        String line = sc.nextLine();
        String[] lines = line.split(" ");

        if(lines.length == t1) {

            int[] intToLines = new int[lines.length];
            for (int i = 0; i < lines.length; i++) {
                intToLines[i] = Integer.parseInt(lines[i]);
            }

            for (int j =0; j < intToLines.length; j++){
                if(t2 > intToLines[j]) System.out.print(intToLines[j] +" ");
            }
        }

    }
}
