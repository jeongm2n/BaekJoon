package Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            if((int)Math.abs(o1)==(int)Math.abs(o2)) return o1 - o2;
            return (int)Math.abs(o1) - (int)Math.abs(o2);
        });
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++){
            int input = Integer.parseInt(br.readLine());
            if(input==0){
                if(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
                else sb.append(0).append("\n");
            }else pq.offer(input);
        }
        System.out.println(sb);
    }
}
