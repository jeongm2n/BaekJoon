package Sort;

import java.io.*;
import java.util.*;

public class Q14469 {
    static class Cow{
        int s, e;
        public Cow(int s, int e){
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Cow> pq = new PriorityQueue<>((o1,o2)->{return o1.s-o2.s;});

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new Cow(s, e));
        }

        Cow first = pq.poll();
        int time = first.s + first.e;
        
        while(!pq.isEmpty()){
            Cow cur = pq.poll();
            if(cur.s>time) time = cur.s+cur.e;
            else time += cur.e;
        }

        System.out.println(time);
    }
}
