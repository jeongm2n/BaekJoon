package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17182 {
    static int N, K;
    static int[][] graph;
    static int result = Integer.MAX_VALUE;
    static boolean[] visited;

    static void floyd(){
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(graph[i][j]>graph[i][k]+graph[k][j]){
                        graph[i][j] = graph[i][k]+graph[k][j];
                    }
                }
            }
        }
    }
    
    static void dfs(int s, int sum, int cnt){
        if(cnt==N-1){
            result = Math.min(result, sum);
            return;
        }
    
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, sum+graph[s][i], cnt+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        visited[K] = true;
        floyd();
        dfs(K, 0, 0);

        System.out.println(result);
    }
}
