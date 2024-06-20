package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11562 {
    static int[][] dist;
    static int n;
    static final int INF = 1000001;

    static void floyd(){
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
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

        dist = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(r==0){
                dist[u][v] = 0;
                dist[v][u] = 1;
            }else{
                dist[u][v] = 0;
                dist[v][u] = 0;
            }
        }

        floyd();

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dist[s][e]).append("\n");
        }

        System.out.println(sb);
    }
}
