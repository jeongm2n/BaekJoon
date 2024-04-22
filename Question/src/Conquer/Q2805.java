package Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805 {
    static int result = 0;
    static int[] t;

    public static void divide(int s, int e, int m){
        int middle = (s+e)/2;
        long sum = 0;
        for(int i : t){
            if(i>middle) sum += i - middle;
        }
        if(sum==m){
            result = middle; 
            return;
        }
        else if(sum>m) divide(middle+1,e,m);
        else divide(s,middle-1,m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        t = new int[n];

        for(int i=0; i<n; i++){
            t[i] = Integer.parseInt(st.nextToken());
        }
        int max = Arrays.stream(t).max().getAsInt();

        divide(1,max,m);
        System.out.println(result);
    }
}