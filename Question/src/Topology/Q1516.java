package Topology;

import java.io.*;
import java.util.*;

public class Q1516 {
    static int N, indegree[], result[], time[];
    static ArrayList<Integer>[] graph;

    static void topology(){
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int v : graph[cur]){
                result[v] = Math.max(result[v], result[cur] + time[cur]);
                indegree[v]--;
                if(indegree[v]==0) q.offer(v);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) sb.append(result[i] + time[i] + "\n");

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        graph = new ArrayList[N+1];
        indegree = new int[N+1];
        result = new int[N+1];
        time = new int[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            time[i] = t;

            int v;
            while ((v = Integer.parseInt(st.nextToken()))!=-1) { 
                graph[v].add(i);
                indegree[i]++;
            }
        }

        topology();
    }
}
