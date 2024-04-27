package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9370 {
    static class Node{
        int d;
        int w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    static final int INF = 2000000;
    static int min = Integer.MAX_VALUE;
    static int n;

    static int dijkstra(int start, int end){
        for(int i=1; i<=n; i++) visited[i] = false;
        Arrays.fill(dist,INF);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.w-o2.w);
        pq.add(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            visited[node.d] = true;

            for(Node newNode : graph[node.d]){
                int d = newNode.d;
                int w = newNode.w;

                if(!visited[d] && dist[d]>dist[node.d]+w){
                    dist[d] = dist[node.d] + w;
                    pq.offer(new Node(d,dist[d]));
                }
            }
        }
        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int z=0; z<T; z++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //정점 개수
            int m = Integer.parseInt(st.nextToken()); //간선 개수
            int t = Integer.parseInt(st.nextToken()); //목적지 후보 개수

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList[n+1];
            visited = new boolean[n+1];
            dist = new int[n+1];

            for(int i=1; i<=n; i++){
                graph[i] = new ArrayList<Node>();
            }

            for(int y=0; y<m; y++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b,d));
                graph[b].add(new Node(a,d));
            }

            ArrayList<Integer> ds = new ArrayList<>();
            for(int x=0; x<t; x++){
                int candi = Integer.parseInt(br.readLine());
                int dist1 = 0; int dist2 = 0; int dist3 = 0;
                dist1 += dijkstra(s,g);
                dist1 += dijkstra(g,h);
                dist1 += dijkstra(h,candi);

                dist2 += dijkstra(s,h);
                dist2 += dijkstra(h,g);
                dist2 += dijkstra(g,candi);

                dist3 = dijkstra(s,candi);

                if(dist3==dist1 || dist3==dist2) ds.add(candi);
            }
            Collections.sort(ds);
            for(int i : ds) sb.append(i).append(" "); 
            
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
