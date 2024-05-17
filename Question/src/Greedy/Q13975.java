package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        for(int z=0; z<T; z++){
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0; i<k; i++) pq.offer(Long.parseLong(st.nextToken()));

            Long result = (long) 0;

            while(pq.size()>1){
                Long f1 = pq.poll();
                Long f2 = pq.poll();

                pq.offer(f1+f2);
                result += f1+f2;
            }
            
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }   
}
