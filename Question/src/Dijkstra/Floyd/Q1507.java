package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1507 {
    static int[][] dist;
    static int[][] graph;

    static void floyd(int N){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(k==i || k==j || i==j) continue;
                    if(dist[i][j]==dist[i][k] + dist[k][j]) graph[i][j] = 0;
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }  
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dist = new int[N+1][N+1];
        graph = new int[N+1][N+1];

        StringTokenizer st;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) graph[i][j] = dist[i][j] = Integer.parseInt(st.nextToken());
        }

        floyd(N);

        int result = 0;
        for(int i=1; i<=N; i++){
            for(int j : graph[i]){
                result += j;
            }
        }

        System.out.println(result/2);
        
    }
}
