package Stack;

import java.util.*;

public class Q17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean reverse = true;

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            switch(c){
                case '<':
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    reverse = false;
                    sb.append('<');
                    break;
                case '>':
                    reverse = true;
                    sb.append('>');
                    break;
                default:
                    if(!reverse){
                        sb.append(c);
                    }else{
                        if(c==' '){
                            while(!stack.isEmpty()) sb.append(stack.pop());
                            sb.append(' ');
                        }else stack.push(c);
                    }
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }   
}
