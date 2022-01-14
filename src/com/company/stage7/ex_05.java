package com.company.stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class ex_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] str = input.split("");

        char[] c = new char[26];
        int[] result = new int[26];
        for(int i =0; i< 26; i++){
            c[i] = ((char)('a'+ i ));
            result[i] = 0;
        }

        for(int i = 0; i< str.length; i++){
            for(int j =0; j<c.length; j++){
                if(str[i].equals(String.valueOf(c[j]))||str[i].equals(String.valueOf(c[j]).toUpperCase(Locale.ROOT)))
                        result[j] = result[j]++;
            }
        }
        int max =0;
        for(Integer val : result){
            if(max < val)
                max = val;
        }
        int overlap = 0;
        int index = 0;
        // 지금 무조건 ? 출력됨.
        for(int i =0; i < result.length; i++ ){
            if(max == result[i])
                index = i;
                overlap++;
        }
        System.out.println(overlap);
        if (overlap > 1) System.out.println("?");
        else System.out.println(String.valueOf(c[index]).toUpperCase(Locale.ROOT));
    }
}
