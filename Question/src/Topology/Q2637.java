package Topology;

import java.io.*;
import java.util.*;

public class Q2637 {
    static class Parts{
        int y;
        long k;
        public Parts(int y, long k){
            this.y = y;
            this.k = k;
        }
    }

    static int N, M, indegree_x[], indegree_y[];
    static long result[];
    static ArrayList<Parts>[] graph;

    static void topology(){
        Queue<Parts> q = new LinkedList<>();
        q.offer(new Parts(N, 1));
        result[N] = 1;

        while(!q.isEmpty()){
            Parts cur = q.poll();

            for(Parts next : graph[cur.y]){
                result[next.y] += result[cur.y] * next.k;
                indegree_y[next.y]--;
                if(indegree_y[next.y]==0) q.offer(new Parts(next.y, result[next.y]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) if(indegree_x[i]==0) sb.append(i + " " + result[i]).append("\n");

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        indegree_x = new int[N+1];
        indegree_y = new int[N+1];
        result = new long[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph[x].add(new Parts(y, k));
            indegree_x[x]++; //기본 부품 찾기 위함
            indegree_y[y]++;
        }

        topology();
    }
}
