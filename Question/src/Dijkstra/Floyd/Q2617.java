package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2617 {
    static int N;
    static int[][] graph;
    static final int INF = 1000001;

    static void floyd(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(i==j) continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[f][b] = 1;
        }

        floyd();

        int mid = (N+1)/2;
        int[] big = new int[N+1];
        int[] small = new int[N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i!=j && graph[i][j]!=INF){
                    big[i]++;
                    small[j]++;
                }
            }
        }

        int result = 0;
        for(int i=1; i<=N; i++){
            if(big[i]>=mid) result++;
            if(small[i]>=mid) result++;
        }

        System.out.println(result);
    }
}
