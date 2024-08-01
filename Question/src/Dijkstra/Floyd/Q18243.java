package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18243 {
    static int[][] dist;
    static final int INF = 1000001;
    static int N;

    static void floyd(){    
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    dist[i][j] = Math.min(dist[i][k]+dist[k][j], dist[i][j]);
                }
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if((dist[i][j]==INF && i!=j) || dist[i][j]>6){
                    System.out.println("Big World!");
                    System.exit(0);
                }
            }
        }

        System.out.println("Small World!");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        } 

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dist[u][v] = 1;
            dist[v][u] = 1;
        }

        floyd();

    }
}
