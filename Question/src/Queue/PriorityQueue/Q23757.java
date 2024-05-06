package Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q23757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        int[] w = new int[m];

        for(int i=0; i<m; i++){
            w[i] = Integer.parseInt(st.nextToken());
        }
        boolean result = true;
        for(int i : w){
            if(i>pq.peek()){
                result = false;
                break;
            }else{
                pq.offer(pq.poll()-i);
            }
        }

        if(result) System.out.println(1);
        else System.out.println(0);
    }
}
