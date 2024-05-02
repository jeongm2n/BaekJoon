package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for(int i=0; i<s.length(); i++){
            String o = Character.toString(s.charAt(i));
            left.push(o);
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            
            switch(st.nextToken()){
                case "L":
                    if(!left.isEmpty()) right.push(left.pop());
                    break;
                case "D":
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case "B":
                    if(!left.isEmpty()) left.pop();
                    break;
                case "P":
                    left.push(st.nextToken());
            }
        }

        while(!left.isEmpty()){
            right.push(left.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!right.isEmpty()){
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
