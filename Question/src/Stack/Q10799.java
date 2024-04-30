package Stack;

import java.util.*;

public class Q10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Stack<Character> st = new Stack<>();
        int result = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(') st.push('(');
            else{
                st.pop();
                if(str.charAt(i-1)=='(') result += st.size();
                else result++;
            }
        }

        System.out.println(result);
    }
}
