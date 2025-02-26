package Queue.Deque;

import java.io.*;
import java.util.*;

public class Q27497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Character> dq = new LinkedList<>();

        StringTokenizer st;
        int back = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if(command==3 && !dq.isEmpty()){
                if(back==1) dq.pollLast();
                else dq.pollFirst();
            }
            else if(command==1) {
                char c = st.nextToken().charAt(0);
                dq.offerLast(c);
            }
            else {
                char c = st.nextToken().charAt(0);
                dq.offerFirst(c);
            }
            back = command==3 ? back : command;
        }

        StringBuilder sb = new StringBuilder();
        if(dq.isEmpty()) {
            System.out.println("0");
            return;
        }
        
        while(!dq.isEmpty()) sb.append(dq.pollFirst());

        System.out.println(sb);
    }
}
