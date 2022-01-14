package com.company.stage6;

public class ex_02 {
    public static void main(String[] args){
        int index = 10000;
        boolean[] result = new boolean[index]; // 결과 담을 배열

        for(int i =0; i< result.length; i++){
            if(d(i+1) < index+1 ) // n의 최대가 10000
                result[d(i+1)-1] = true; // 셀프 넘버가 아닌 것
            // i = 8
            // d(8) = 8 + 8 =16
            // result[15] = true
        }
        for(int i =0; i<result.length; i++){
            if(result[i] == false) // i에 담긴 게 실제로 i+1에 해당하는 값이다.
                System.out.println(i+1);
        }
    }
    public static int d(int n){
        int self = n; // 자기 자신
        while(n>0){ // n==0이면, 일의자리까지 연산이 왔다는 의미
            self += (n%10); // 자릿수 더하기
            n /=10; // 일의자리가 될 때까지 나눠
        }
        return self;
    }
}