package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        Deque<String> dq;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int z=0; z<t; z++){
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(),"[],");

            dq = new ArrayDeque<>();
            boolean direction = false;
            boolean err = false;
            for(int i=0; i<n; i++) dq.offer(st.nextToken());
            
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);

                if(c=='R'){
                    direction = !direction;
                }
                if(c=='D'){
                    if(dq.isEmpty()){
                        err = true;
                        break;
                    }else{
                        if(direction) dq.pollLast();
                        else dq.pollFirst();
                    }
                }
            }

            if(!err){
                if(dq.peek()==null) sb.append("[]").append("\n");
                else{
                    sb.append("[");
                    if(!direction){
                        while(dq.size()>1) sb.append(dq.pollFirst()).append(",");
                    }else{
                        while(dq.size()>1) sb.append(dq.pollLast()).append(",");
                    }
                    sb.append(dq.poll()).append("]").append("\n");
                }
            }
            else sb.append("error").append("\n");
        }

        System.out.println(sb);
    }
}
