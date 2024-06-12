package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11780 {
    static int N;
    static int[][] dist;
    static ArrayList<Integer>[][] path;
    static final int INF = 100*100000+1;

    static void floyd(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];

                        path[i][j].clear();
                        for(int p : path[i][k]) path[i][j].add(p);
                        path[i][j].add(k);
                        for(int p : path[k][j]) path[i][j].add(p);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dist = new int[N+1][N+1];
        path = new ArrayList[N+1][N+1];

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=1; i<=N; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
            for(int j=1; j<=N; j++){
                path[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[s][e] = Math.min(dist[s][e], w);
        }

        floyd();

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(dist[i][j]==INF){
                    sb.append(0 + " ");
                    continue;
                }
                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j){
                    sb.append(0).append("\n");
                    continue;
                }
                int size = path[i][j].size();
                sb.append(size+2 + " " + i + " ");
                for(int v : path[i][j]) sb.append(v + " ");
                sb.append(j).append("\n");
            }
        }

        System.out.println(sb);
    }
}
