package Topology;

import java.io.*;
import java.util.*;

public class Q2252 {
    static ArrayList<Integer>[] graph;
    static int N, M, indegree[];

    static void topology(){
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            if(indegree[i]==0) q.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur + " ");
            
            for(int v : graph[cur]){
                indegree[v]--;
                if(indegree[v]==0) q.offer(v);
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
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            indegree[e]++;
        }

        topology();
    }
}
