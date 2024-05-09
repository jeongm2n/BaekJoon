package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int len = n-k;

        Stack<Integer> stack = new Stack<>();


        String num = br.readLine();

        int cnt = 0;

        for(int i=0; i<n; i++){
            int a = num.charAt(i)-'0';
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && k>0 && stack.peek()<a){
                    stack.pop();
                    k--;
                }
            }
            if(stack.size()<len){
                stack.push(a);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<stack.size(); i++){
            sb.append(stack.get(i));
        }

        System.out.println(sb);
    }
}
