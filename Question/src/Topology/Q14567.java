package Topology;

import java.io.*;
import java.util.*;

public class Q14567 {
    static int N, M, indegree[], result[];
    static ArrayList<Integer>[] graph;

    static void topology(){
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            if(indegree[i]==0) {
                result[i] = 1;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int v : graph[cur]){
                indegree[v]--;
                if(indegree[v]==0){
                    q.offer(v);
                    result[v] = result[cur]+1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) sb.append(result[i] + " ");

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        indegree = new int[N+1];
        result = new int[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            indegree[B]++;
        }

        topology();
    }   
}