package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11000 {
    static class Class{
        int s;
        int e;
        public Class(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<Class> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new Class(s,e));
        }

        Collections.sort(arr, (o1,o2)->{
            if(o1.s==o2.s) return o2.e - o1.e;
            return o1.s-o2.s;
        });

        for(Class c : arr){
            if(!pq.isEmpty() && pq.peek()<=c.s) pq.poll();
            pq.offer(c.e);
        }

        System.out.println(pq.size());
    }
}
