package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        Integer[] alpha = new Integer[26];

        Arrays.fill(alpha, 0);

        for(int i=0; i<n; i++){
            int pos = 1;
            String str = br.readLine();

            char[] arr = str.toCharArray();
            for(int j=arr.length-1; j>=0; j--){
                alpha[arr[j]-'A'] += pos;
                pos *= 10;
            }
        }

        Arrays.sort(alpha, Collections.reverseOrder());

        int num = 9;
        int result = 0;

        for(int i=0; i<26; i++){
            if(alpha[i] == 0) break;
            result += alpha[i]*num;
            num--;
        }

        System.out.println(result);
    }
}
