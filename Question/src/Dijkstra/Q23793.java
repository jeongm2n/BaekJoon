package Dijkstra;

import java.io.*;
import java.util.*;

public class Q23793 {
    static class Node{
        int d, w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static int N, M, X, Y, Z;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;

    static int dijkstra(int s, int e, int ver){
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});
        visited[s] = true;
        dist[s] = 0;
        q.offer(new Node(s, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.d==e) return cur.w;

            for(Node n : graph[cur.d]){
                int d = n.d;
                int w = n.w;

                if(ver==2 && d==Y) continue;

                if(!visited[d] && dist[d] > dist[cur.d] + w){
                    visited[d] = true;
                    dist[d] = dist[cur.d] + w;
                    q.offer(new Node(d, dist[d]));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        Arrays.fill(dist, INF);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());

        int result1 = dijkstra(X, Y, 1);
        int result2 = dijkstra(Y, Z, 1);
        int ver2 = dijkstra(X, Z, 2);

        int ver1=0;
        ver1 = (result1==-1 || result2==-1) ? -1 : result1 + result2;

        System.out.println(ver1 + " " + ver2);
    } 
}
