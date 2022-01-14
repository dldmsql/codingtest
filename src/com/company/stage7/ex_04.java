package com.company.stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tCNum = Integer.parseInt(br.readLine());

        for(int i =0 ; i < tCNum; i++){
            String[] ss= br.readLine().split(" ");
            int r = Integer.parseInt(ss[0]);
            String s = ss[1];
            for(int j =0; j < s.length(); j++){
                for(int k =0; k < r; k++){
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }

}
