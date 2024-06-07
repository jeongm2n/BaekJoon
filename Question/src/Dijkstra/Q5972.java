package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5972 {
    static class Barn{
        int d, w;
        public Barn(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static ArrayList<Barn>[] graph;
    static boolean[] visited;
    static int dist[];
    static final int INF = 500000001;

    static void dijkstra(){
        PriorityQueue<Barn> q = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});
        q.offer(new Barn(1, 0));
        dist[1] = 0;

        while(!q.isEmpty()){
            Barn b = q.poll();

            if(visited[b.d]) continue;
            visited[b.d]=true;

            for(Barn i : graph[b.d]){
                int d = i.d;
                int w = i.w;
                if(dist[d]>dist[b.d]+w){
                    dist[d] = dist[b.d] + w;
                    q.offer(new Barn(d, dist[d]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<Barn>();
        Arrays.fill(dist, INF);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s].add(new Barn(e, w));
            graph[e].add(new Barn(s, w));
        }

        dijkstra();
        System.out.println(dist[N]);
    }
}
