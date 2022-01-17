package com.company.stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pnum = br.readLine();
        int time =0;
       for(int i=0; i<pnum.split("").length; i++){
            switch (pnum.split("")[i]){
                case "A" : case "B" :  case "C": time +=3; break;
                case "D" : case "E" :  case "F": time +=4; break;
                case "G" : case "H" :  case "I": time +=5; break;
                case "J" : case "K" :  case "L": time +=6; break;
                case "M" : case "N" :  case "O": time +=7; break;
                case "P" : case "Q" :  case "R": case "S" : time +=8; break;
                case "V" : case "T" :  case "U": time +=9; break;
                case "W" : case "X" :  case "Y": case "Z" : time +=10; break;
            }
        }
        System.out.println(time);
    }
}
