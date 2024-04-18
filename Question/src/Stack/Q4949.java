package Stack;
import java.util.*;
import java.io.*;

public class Q4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;
            Stack<Character> st = new Stack<>();
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)=='(' || str.charAt(i)=='[') st.push(str.charAt(i));
                else if(str.charAt(i)==')' || str.charAt(i)==']'){
                    if(st.isEmpty()) {
                        st.push(str.charAt(i));
                        break;
                    }else if(str.charAt(i)==')'){
                        if(st.peek()!='(') break;
                        st.pop();
                    }else if(str.charAt(i)==']'){
                        if(st.peek()!='[') break;
                        st.pop();
                    }
                }
            }
            if(st.isEmpty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }      
        System.out.println(sb);  
    }   
}
