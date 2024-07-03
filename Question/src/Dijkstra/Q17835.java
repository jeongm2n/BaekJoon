package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17835 {
    static class City{
        int d;
        long w;
        public City(int d, long w){
            this.d = d;
            this.w = w;
        }
    }

    static long[] dist;
    static ArrayList<City>[] graph;
    static int N;
    static final long INF = 100_000_000_000L;

    static PriorityQueue<City> q = new PriorityQueue<>((o1,o2)->{return (int)o1.w-(int)o2.w;});

    static void dijkstra(){
        while(!q.isEmpty()){
            City cur = q.poll();

            for(City c : graph[cur.d]){
                int d = c.d;
                long w = c.w;

                if(dist[d] > dist[cur.d]+w){
                    dist[d] = dist[cur.d] + w;
                    q.offer(new City(d, dist[d]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        dist = new long[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, INF);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[e].add(new City(s, w));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int a = Integer.parseInt(st.nextToken());
            q.offer(new City(a, 0));
            dist[a] = 0;
        }

        dijkstra();

        long result = 0;
        int v = 0;

        for(int i=1; i<=N; i++){
            if(result<dist[i]){
                result = dist[i];
                v = i;
            }
        }

        System.out.println(v);
        System.out.println(result);
    }
}
