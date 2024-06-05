package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1613 {
    static int[][] dist;
    static int n;

    static void floyd(){
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dist[i][k]==1 && dist[k][j]==1) dist[i][j] = 1;
                    if(dist[i][k]==-1 && dist[k][j]==-1) dist[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dist = new int[n+1][n+1];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = -1;
            dist[b][a] = 1;
        }

        int s = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        floyd();
        
        for(int i=0; i<s; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dist[start][end]).append("\n");
        }
        System.out.println(sb);
    }
}
