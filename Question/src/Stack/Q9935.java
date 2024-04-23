package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int len1 = str1.length();
        int len2 = str2.length();
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<len1; i++){
            int cnt = 0;
            stack.push(str1.charAt(i));

            if(stack.size() >= len2){
                for(int j=0; j<len2; j++){
                    if(stack.get(stack.size() - len2 + j) == str2.charAt(j)) cnt++;
                    if(cnt==len2){
                        for(int k=0; k<len2; k++){
                            stack.pop();
                        }
                    }
                }
            }
        }
        if(stack.isEmpty()) sb.append("FRULA");
        else for(char c : stack) sb.append(c);

        System.out.println(sb);
    }
}
