package Sort;

import java.io.*;
import java.util.*;

public class Q14729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Float> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) pq.offer(Float.parseFloat(br.readLine()));

        for(int i=0; i<7; i++){
            System.out.printf("%.3f", pq.poll());
        }
    }
}
