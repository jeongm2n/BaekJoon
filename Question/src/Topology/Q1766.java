package Topology;

import java.io.*;
import java.util.*;

public class Q1766 {
    static ArrayList<Integer>[] graph;
    static int N, M, indegree[];
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static void topology(){
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++){
            if(indegree[i]==0) pq.offer(i);
        }

        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur + " ");
            
            for(int n : graph[cur]){
                indegree[n]--;

                if(indegree[n]==0) pq.offer(n);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        indegree = new int[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            indegree[v]++;
        }

        topology();
    }
}
