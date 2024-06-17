package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17396 {
    static class Node{
        int d;
        long w;
        public Node(int d, long w){
            this.d = d;
            this.w = w;
        }
    }
    static int[] ward;
    static ArrayList<Node>[] graph;
    static long[] dist;
    static boolean[] visited;
    static final long INF = Long.MAX_VALUE;
    static int N;

    static void dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{return (int)o1.w-(int)o2.w;});
        q.offer(new Node(0, 0));
        dist[0] = 0;

        while(!q.isEmpty()){
            Node n = q.poll();

            if(visited[n.d]) continue;
            visited[n.d] = true;
            
            for(Node nn : graph[n.d]){
                int d = nn.d;
                long w = nn.w;

                if(d!=N-1 && ward[d] == 1) continue;
                if(dist[d]>dist[n.d]+w){
                    dist[d] = dist[n.d] + w;
                    q.offer(new Node(d, dist[d]));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        ward = new int[N];
        dist = new long[N];
        visited = new boolean[N];

        Arrays.fill(dist, INF);
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            ward[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        } 

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        dijkstra();
        
        System.out.println(dist[N-1]==INF ? -1 : dist[N-1]);
    }
}
