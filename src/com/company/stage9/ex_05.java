package com.company.stage9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ex_05 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int a = sc.nextInt();
            if( a == 0 ){
                break;
            }
            int cnt = 0;
            for(int i = a+1; i <= 2*a; i++){
                if( i == 1) continue;
                boolean isN=  true;
                for(int j = 2; j <= Math.sqrt(i); j++){
                    if(i%j == 0){
                        isN = false;
                        break;
                    }
                }
                if(isN){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

    }
}
