package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> st = new Stack<>();
        long result = 0;

        for(int i=0; i<n; i++){
            int h = Integer.parseInt(br.readLine());

            while(!st.isEmpty()){
                if(st.peek()>h) break;
                st.pop();
            }
            result += st.size();
            st.push(h);
        }
        System.out.println(result);
    }
}
