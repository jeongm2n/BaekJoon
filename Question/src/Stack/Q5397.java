package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();

            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                String c = Character.toString(str.charAt(j));
                switch(c){
                    case "<":
                        if(!left.isEmpty()) right.push(left.pop());
                        break;
                    case ">":
                        if(!right.isEmpty()) left.push(right.pop());
                        break;
                    case "-":
                        if(!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(c);
                }
            }
            
            while(!right.isEmpty()){
                left.push(right.pop());
            }
            while(!left.isEmpty()){
                right.push(left.pop());
            }

            while(!right.isEmpty()){
                sb.append(right.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
