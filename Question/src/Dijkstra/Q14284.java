package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14284 {
    static class Node{
        int d, w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    static final int INF = 100001;

    static int djikstra(int s, int t){
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});
        visited[s] = true;
        dist[s] = 0;
        q.offer(new Node(s, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(Node n : graph[cur.d]){
                int d = n.d;
                int w = n.w;
                if(!visited[d] && dist[d]>dist[cur.d]+w){
                    dist[d] = dist[cur.d] + w;
                    visited[d] = true;
                    q.offer(new Node(d, dist[d]));
                }
            }
        }
        return dist[t];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        dist = new int[n+1];

        for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();
        Arrays.fill(dist, INF);

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        System.out.println(djikstra(s, t));
    }
}
