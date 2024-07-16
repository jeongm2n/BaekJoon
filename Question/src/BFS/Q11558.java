package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11558 {
    static class Node{
        int d, w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N;

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1,0));
        visited[1] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.d==N) return cur.w;

            for(int next : graph[cur.d]){
                if(!visited[next]){
                    q.offer(new Node(next, cur.w+1));
                    visited[next] = true;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            N = Integer.parseInt(br.readLine());

            graph = new ArrayList[N+1];
            visited = new boolean[N+1];

            for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

            for(int i=1; i<=N; i++){
                int A = Integer.parseInt(br.readLine());
                graph[i].add(A);
            }

            int result = bfs();
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
