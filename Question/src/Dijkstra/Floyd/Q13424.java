package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13424 {
    static int[][] dist;
    static final int INF = 10000001;
    static int[] student;
    static int N, K;
    static StringBuilder sb = new StringBuilder();

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

        int min = INF, idx = -1;
        for(int i=1; i<=N; i++){
        
            int sum = 0;
            
            for(int j=0; j<K; j++)
                sum += dist[student[j]][i];

            if(sum < min){
                idx = i;
                min = sum;
            }
        }
        sb.append(idx).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T>0){
            T--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
    
            dist = new int[N+1][N+1];
            for(int i=1; i<=N; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }
    
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
    
                dist[a][b] = w;
                dist[b][a] = w;
            }

            K = Integer.parseInt(br.readLine());
            student = new int[K];
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<K; i++){
                student[i] = Integer.parseInt(st.nextToken());
            }

            floyd();
        }
        System.out.println(sb);
    }
}
