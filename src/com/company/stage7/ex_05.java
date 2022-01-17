package com.company.stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class ex_05 {
    public static void main(String[] args) throws IOException {
        // A 65 a 97
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        br.close();

        int[] cnt = new int[26];
        int max = 0;
        char result = '?';

        for(int i =0; i< input.length(); i++){
            if(input.charAt(i) >= 97){
                cnt[input.charAt(i) - 97]++;

                if( max < cnt[input.charAt(i) - 97] ){
                    result = (char) (input.charAt(i) - 32);
                    max =  cnt[input.charAt(i) - 97];
                }else if( max ==  cnt[input.charAt(i) - 97]) {
                    result = '?';
                }
            } else {
                cnt[input.charAt(i) - 65]++;

                if( max < cnt[input.charAt(i) -65]){
                    result = input.charAt(i);
                    max = cnt[input.charAt(i)-65];
                } else if( max == cnt[input.charAt(i)-65]){
                    result = '?';
                }
            }
        }
        System.out.println(result);
    }
}
