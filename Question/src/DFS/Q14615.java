package DFS;

import java.io.*;
import java.util.*;

public class Q14615 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int result;

    static void dfs(int s, int e){
        visited[s] = true;

        for(int v : graph[s]){
            if(!visited[v]){
                if(v==e){
                    result++;
                    break;
                }
                else dfs(v,e);
            }
        }
        
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            graph[X].add(Y);
        }

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int C = Integer.parseInt(br.readLine());
            result = -1;
            visited = new boolean[N+1];
            dfs(1, C);
            visited = new boolean[N+1];
            dfs(C, N);
            
            sb.append(result<=0 ? "Destroyed the CTP" : "Defend the CTP").append("\n");
        }

        System.out.println(sb);
    }   
}
