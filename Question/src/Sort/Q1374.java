package Sort;

import java.io.*;
import java.util.*;

public class Q1374 {
    static class Class{
        int num;
        long s, e;
        public Class(int num, long s, long e){
            this.num = num;
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Class> pq = new PriorityQueue<>((o1,o2)->{return (int)o1.s-(int)o2.s;});
        PriorityQueue<Long> tq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            pq.offer(new Class(num, s, e));
        }
        
        Class first = pq.poll();
        int result = 1;
        tq.offer(first.e);

        while(!pq.isEmpty()){
            Class cur = pq.poll();
            Long time = tq.peek();

            if(cur.s<time) result++;
            else tq.poll();
            tq.offer(cur.e);
        }

        System.out.println(result);
    }
}
