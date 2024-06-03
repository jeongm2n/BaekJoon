package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2660 {
    static int N;
    static int[][] dist;
    static final int INF = 100001;
    static int[] points;

    static int floyd(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(i==j) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        int leader = INF;
        for(int i=1; i<=N; i++){
            int max = 0;
            for(int j=1; j<=N; j++){
                max = Math.max(max, dist[i][j]);
            }
            points[i] = max;
            leader = Math.min(max, leader);
        }
        return leader;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        dist = new int[N+1][N+1];
        points = new int[N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(u==-1 && v==-1) break;

            dist[u][v] = 1;
            dist[v][u] = 1;
        }

        int leader = floyd();
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=1; i<=N; i++){
            if(points[i]==leader){
                arr.add(i);        
            }
        }

        sb.append(leader + " " + arr.size()).append("\n");

        for(int i : arr) sb.append(i + " ");
        System.out.println(sb);
    }
}
