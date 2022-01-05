package com.company.stage4;

import java.util.Scanner;

public class ex_03 {

    public static void main(String[] args)  {

        Scanner br = new Scanner(System.in);
        int num = br.nextInt();
        boolean flag = true;
        int cnt = 0;
        int n1;
        if(num< 10)  {n1 =0;}
        else {n1 = num/10;}
        int n2 = num%10;
        int temp1 = n1;
        int temp2 = n2;
        int n3;

        while(flag){
            n3 = (n1 + n2)%10;
            n1 = n2;
            n2 = n3;
            cnt ++;
            if(temp1 == n1 && temp2 == n2) flag = false;
        }
        System.out.print(cnt);
    }

}
