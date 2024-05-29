package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11779 {
    static class Node{
        int d, w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }
    static ArrayList<Node>[] graph;
    static int[] dist, city;

    static void dijkstra(int s, int e){
        Queue<Node> q = new LinkedList<>();
        dist[s] = 0;
        q.offer(new Node(s, 0));

        while(!q.isEmpty()){
            Node n = q.poll();

            if(n.d==e) return;

            for(Node nn : graph[n.d]){
                int d = nn.d;
                int w = nn.w;

                if(dist[d]>dist[n.d]+w){
                    city[d] = n.d;
                    dist[d] = dist[n.d] + w;
                    q.offer(new Node(d, dist[d]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[n+1];
        dist = new int[n+1];
        city = new int[n+1];
        Arrays.fill(dist, 100000001);

        for(int i=1; i<=n; i++) graph[i] = new ArrayList<Node>();

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijkstra(s, e);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[e]).append("\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(e);
        while(e!=s){
            stack.push(city[e]);
            e = city[e];
        }

        sb.append(stack.size()).append("\n");

        while(!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }
}
