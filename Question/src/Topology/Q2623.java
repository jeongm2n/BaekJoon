package Topology;

import java.io.*;
import java.util.*;

public class Q2623 {
    static int N, M, indegree[];
    static ArrayList<Integer>[] graph;


    static void topology(){
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for(int i=1; i<=N; i++) if(indegree[i]==0) q.offer(i);

        int cnt = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            result.offer(cur);
            cnt++;

            for(int v : graph[cur]){
                indegree[v]--;
                if(indegree[v]==0) q.offer(v);
            }
        }

        if(cnt!=N) {
            System.out.println("0");
        }else{
            StringBuilder sb = new StringBuilder();
            while(!result.isEmpty()) sb.append(result.poll()).append("\n");
    
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        graph = new ArrayList[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            for(int j=0; j<n-1; j++){
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                indegree[e]++;
                s = e;
            }
        }

        topology();
    }
}
