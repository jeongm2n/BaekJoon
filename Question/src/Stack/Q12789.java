package Stack;
import java.io.*;
import java.util.*;

public class Q12789 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();

        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            q.offer(sc.nextInt());
        }
        int idx = 1;

        while(!q.isEmpty()){
            if(q.peek()==idx){
                q.poll();
                idx++;
                continue;
            }else if(!st.isEmpty() && st.peek()==idx){
                st.pop();
                idx++;
                continue;
            }
            st.push(q.poll());
        }

        while(!st.isEmpty()){
            if(st.peek()==idx){
                st.pop();
                idx++;
            }else{
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
    }
}
