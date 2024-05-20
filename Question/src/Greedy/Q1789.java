package Greedy;

import java.util.Scanner;

public class Q1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long S = sc.nextLong();

        long result = 0;
        int N = 0;

        for(int i=1; i<=S; i++){
            if(result > S) break;
            result += i;
            N++;
        }

        if(S==1) System.out.println(N);
        else System.out.println(N-1);
    }
}
