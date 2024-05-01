package Stack;

import java.util.*;

public class Q2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        int val = 1;

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c == '('){
                stack.push(c);
                val *= 2;
            }else if(c=='['){
                stack.push(c);
                val *= 3;
            }else if(c == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					result = 0;
					break;
				}
				else if(str.charAt(i-1)=='(') {
					result += val;
				}
				stack.pop();
				val /= 2;
			}else if(c==']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					result = 0;
					break;
				}
				else if(str.charAt(i-1)=='[') {
					result += val;
				}
				stack.pop();
				val /= 3;
			}
        }
        if(!stack.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(result);
		}
    }
}
