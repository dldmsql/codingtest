package com.company.stage4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine() )!= null){
            System.out.println(splitToInt(str)[0] + splitToInt(str)[1]);

        }
    }
    public static int[] splitToInt(String input){
        int[] ns = new int[2];
        String[] inputs = input.split(" ");
            ns[0] = Integer.parseInt(inputs[0]);
            ns[1] = Integer.parseInt(inputs[1]);
        return ns;
    }
}
