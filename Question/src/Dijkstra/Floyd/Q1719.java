package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1719 {
    static int n;
    static int[][] graph;
    static int[][] dist;
    static final int INF = 200*10000+1;

    static void floyd(){
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dist[i][j]>dist[i][k]+dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        graph[i][j] = graph[i][k];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        dist = new int[n+1][n+1];  

        for(int i=1; i<=n; i++) {
            Arrays.fill(dist[i], INF);
            for(int j=1; j<=n; j++){
                graph[i][j] = j;
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
        
            dist[s][e] = dist[e][s] = Math.min(dist[s][e], w);
        }

        floyd();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j){
                    sb.append("-" + " ");
                    continue;
                }
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
