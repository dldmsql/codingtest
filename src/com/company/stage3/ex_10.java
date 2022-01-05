package com.company.stage3;

import java.util.Scanner;

public class ex_10 { // 인터넷 풀이 보고 함.

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for(int i = 1; i < t+1; i++){ // 5개의 row 생성
            for (int j = t; j >0; j--) { // 별 만들기
                if(i<j) { System.out.print(" ");} // 우측 정렬을 위한 띄워쓰기
                else { System.out.print("*");} // 별 생성
            }
            System.out.println(""); // 줄바꿈
        }

    }

}
