package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1202 {
    static class Jewel{
        int w;
        int v;

        public Jewel(int w, int v){
            this.w = w;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{return o2-o1;});

        Jewel[] jewels = new Jewel[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels[i] = new Jewel(w, v);
        }

        Arrays.sort(jewels, (o1,o2)->{
            if(o1.w==o2.w) return o2.v-o1.v;
            return o1.w-o2.w;
        });

        int[] bag = new int[k];

        for(int i=0; i<k; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);

        long result = 0;
        int cnt = 0;

        for(int i=0; i<k; i++){
            while(cnt<n && jewels[cnt].w <= bag[i]){
                pq.offer(jewels[cnt++].v);
            }
            if(!pq.isEmpty()) result += pq.poll();
        }

        System.out.println(result);
    }
}
