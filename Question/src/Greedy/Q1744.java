package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        int result = 0;

        for(int i=0; i<n; i++){
            int a = Integer.parseInt(br.readLine());
            if(a>0) plus.offer(a);
            else minus.offer(a);
        }

        while(!plus.isEmpty()){
            int a = plus.poll();
            if(plus.isEmpty()){
                result += a;
                break;
            }
            int b = plus.poll();

            if(a==1 || b==1){
                result += a+b;
            }else{
                result += a*b;
            }
        }

        while(!minus.isEmpty()){
            int a = minus.poll();
            if(minus.isEmpty()){
                result += a;
                break;
            }
            int b = minus.poll();
            result += a*b;
        }

        System.out.println(result);
    }
}
