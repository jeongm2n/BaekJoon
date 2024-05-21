package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int min1 = 1001;
        int min6 = 1001;

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int p6 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());

            min6 = Math.min(min6,p6);
            min1 = Math.min(min1,p1);
        }

        int result = 0;

        if(min6>min1*6){
            result = min1*n;
        }else{
            result = min6*(n/6);
            result += Math.min(min1*(n%6), min6);
        }

        System.out.println(result);
    }
}
