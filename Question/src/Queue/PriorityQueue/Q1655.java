package Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1655 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> maxheap = new PriorityQueue<>((o1,o2)->{return o2-o1;});
        Queue<Integer> minheap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int a = Integer.parseInt(br.readLine());
            if(maxheap.size() == minheap.size()) maxheap.add(a);
            else minheap.add(a);

            if(!maxheap.isEmpty() && !minheap.isEmpty()){
                if(maxheap.peek()>minheap.peek()){
                    int tmp1 = maxheap.poll();
                    int tmp2 = minheap.poll();
    
                    maxheap.offer(tmp2);
                    minheap.offer(tmp1);
                }
            }
            sb.append(maxheap.peek()).append("\n");
        }
        System.out.println(sb);
    }    
}
