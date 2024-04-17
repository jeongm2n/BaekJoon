package Stack;
import java.util.*;
import java.io.*;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            Stack<Character> st = new Stack<>();
            String str = br.readLine();

            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)=='(') st.push(str.charAt(j));
                else if(st.isEmpty()){
                    st.push(str.charAt(j));
                    break;
                }
                else st.pop();
            }
            if(!st.isEmpty()) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
