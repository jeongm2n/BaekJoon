package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q24447 {
    static ArrayList<Integer>[] graph;
    static long[] visited;
    static long[] depth;

    static void bfs(int R){
        Queue<Integer> q = new LinkedList<>();
        depth[R] = 0;
        q.offer(R);
        long cnt = 1;
        visited[R] = cnt++;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int v : graph[cur]){
                if(depth[v]==-1){
                    q.offer(v);
                    depth[v] = depth[cur]+1;
                    visited[v] = cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new long[N+1];
        depth = new long[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        Arrays.fill(depth, -1);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=1; i<=N; i++) Collections.sort(graph[i], (o1,o2)->{return o1-o2;});

        bfs(R);

        long sum = 0;
        for(int i=1; i<=N; i++) sum += depth[i] * visited[i];

        System.out.println(sum);
    }
}
