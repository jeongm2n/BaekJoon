package Topology;

import java.io.*;
import java.util.*;

public class Q1005 {
    static int N, K, W, indegree[], time[], result[];
    static ArrayList<Integer>[] graph;

    static int topology(){
        Queue<Integer> q = new LinkedList<>();
        result = new int[N+1];

        for(int i=1; i<=N; i++){
            result[i] = time[i];
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int v : graph[cur]){
                result[v] = Math.max(result[v], result[cur]+time[v]);
                indegree[v]--;
                if(indegree[v]==0) q.offer(v);
            }
        }

        return result[W];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        indegree = new int[N+1];
        time = new int[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) time[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            indegree[e]++;
        }

        W = Integer.parseInt(br.readLine());

        sb.append(topology() + "\n");
        }
        System.out.println(sb);
    }
}
