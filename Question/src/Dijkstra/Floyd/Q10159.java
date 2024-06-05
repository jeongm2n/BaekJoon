package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10159 {
    static int N;
    static int[][] dist;

    static void floyd(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(dist[i][k]==1 && dist[k][j]==1) dist[i][j] = 1;
                    if(dist[i][k]==-1 && dist[k][j]==-1) dist[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        dist = new int[N+1][N+1];

        for(int i=1; i<=N; i++) dist[i][i] = 1;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            dist[s][e] = 1;
            dist[e][s] = -1;
        }
        
        floyd();

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            int cnt = 0;
            for(int j=1; j<=N; j++){
                if(dist[i][j]==0) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
