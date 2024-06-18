package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14496 {
    static class Node{
        int d, w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static int bfs(int s, int e){
        visited[s] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s, 0));

        while(!q.isEmpty()){
            Node n = q.poll();
            int d = n.d;
            int w = n.w;

            if(d==e) return w;

            for(int i : graph[d]){
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(new Node(i, w+1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int result = bfs(a, b);
        System.out.println(result==-1 ? -1 : result);
    }
}
