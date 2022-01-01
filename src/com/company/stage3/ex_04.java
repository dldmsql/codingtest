package com.company.stage3;

import java.io.*;

public class ex_04 {

    public static void main(String[] args)  {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int t = Integer.parseInt(sc.readLine());
            if(t <= 1000000) {
                for (int i = 0; i < t; i++) {
                    String inputs = sc.readLine();
                    String[] input = inputs.split(" ");
                    int a = Integer.parseInt(input[0]);
                    int b = Integer.parseInt(input[1]);
                    bw.write( (a + b) + "\n" );
                }
                bw.flush();
            }
        } catch ( IOException e){
            e.printStackTrace();
        }
    }

}
