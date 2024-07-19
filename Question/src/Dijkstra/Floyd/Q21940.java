package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q21940 {
    static int[][] dist;
    static final int INF = 200 * 200 + 1;
    static int N;

    static void floyd(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
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

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[u][v] = w;
        }
        
        floyd();

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> home = new ArrayList<>();
        for(int i=0; i<K; i++) home.add(Integer.parseInt(st.nextToken()));

        int[] result = new int[N+1];
        for(int i=1; i<=N; i++){
            for(int h : home){
                result[i] = Math.max(result[i], dist[i][h] + dist[h][i]);
            }
        }

        home.clear();
        int min = INF;
        for(int i=1; i<=N; i++){
            if(result[i]<min){
                min = result[i];
                home.clear();
                home.add(i);
            }else if(result[i]==min){
                home.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : home) sb.append(i + " ");
        System.out.println(sb);
    }
}
