package Queue.Deque;

import java.io.*;
import java.util.*;

public class Q18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i=1; i<=N; i++){
            int skill = Integer.parseInt(st.nextToken());

            if(skill==1) dq.offerFirst(i);
            else if(skill==2){
                int tmp = dq.pollFirst();
                dq.offerFirst(i);
                dq.offerFirst(tmp);
            }else dq.offerLast(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!dq.isEmpty()) sb.append(dq.pollFirst() + " ");

        System.out.println(sb);
    }
}
