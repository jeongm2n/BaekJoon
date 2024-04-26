package Conquer;

import java.io.*;
import java.util.StringTokenizer;

public class Q1629 {
    static long recursive(long a, long b, long c){
        if(b==1) return a%c;
        else{
            long half = recursive(a, b/2, c);
            if(b%2==1) return (half*half%c)*a%c;
            else return half*half%c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(recursive(a, b, c));
    }   
}
