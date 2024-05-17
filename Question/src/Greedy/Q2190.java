package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2190 {
    static class Class{
        int p;
        int d;

        public Class(int p, int d){
            this.p = p;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Class> pq = new PriorityQueue<>((o1,o2)->{
            if(o1.p==o2.p) return o1.d - o2.d;
            return o2.p - o1.p;
        }); 

        boolean[] days = new boolean[10001];

        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pq.offer(new Class(p, d));
        }

        int result = 0;

        while(!pq.isEmpty()){
            Class c = pq.poll();
            
            for(int i=c.d; i>=1; i--){
                if(!days[i]){
                    days[i] = true;
                    result += c.p;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
