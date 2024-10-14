package Sort;

import java.io.*;
import java.util.*;

public class Q15720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> bq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> cq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> dq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for(int j=0; j<B; j++) bq.offer(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<C; j++) cq.offer(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<D; j++) dq.offer(Integer.parseInt(st.nextToken()));

        int total = 0;
        int max = 0;

        while(true){
            if(bq.isEmpty() && cq.isEmpty() && dq.isEmpty()) break;

            int sum = 0;
            int cnt = 0;

            if(!bq.isEmpty()){
                int b = bq.poll();
                sum += b;
                max += b;
                cnt++;
            }
            if(!cq.isEmpty()){
                int c = cq.poll();
                sum += c;
                max += c;
                cnt++;
            }
            if(!dq.isEmpty()){
                int d = dq.poll();
                sum += d;
                max += d;
                cnt++;
            }

            if(cnt==3) sum = (int) (sum * 0.9);
            total += sum;
        }

        System.out.println(max + "\n" + total);
    }   
}
