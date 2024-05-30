package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[N+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = true;
        }
  
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(graph[i][k] && graph[k][j]){
                        graph[i][j] = true;
                    }
                }
            }
        }

        int[] rank = new int[N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(graph[i][j] || graph[j][i]) rank[i]++;
            }
        }

        int cnt = 0;
        for(int i=1; i<=N; i++){
            if(rank[i]==N-1) cnt++;
        }

        System.out.println(cnt);
    }
}
