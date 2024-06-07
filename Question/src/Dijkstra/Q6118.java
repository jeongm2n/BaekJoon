package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q6118 {
    static int[] dist;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int max;

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        dist[1] = 0;
        q.offer(1);

        while(!q.isEmpty()){
            int n = q.poll();

            for(int e : graph[n]){
                if(!visited[e]){
                    dist[e] = dist[n] + 1;
                    q.offer(e);
                    visited[e] = true;
                    max = Math.max(max, dist[e]);
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

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }
        max = 0;
        bfs();
        
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=1; i<=N; i++){
            if(max==dist[i]) arr.add(i);
        }
        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(arr.get(0) + " ");
        sb.append(max + " ");
        sb.append(arr.size() + " ");

        System.out.println(sb);
    }
}
