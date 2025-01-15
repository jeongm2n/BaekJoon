package BFS;

import java.io.*;
import java.util.*;

public class Q14502 {
    static int N, M;
    static int[][] graph, copy;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int max = Integer.MIN_VALUE;
    
    static void dfs(int cnt){
        if(cnt==3){
            bfs();
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]==0){
                    graph[i][j]=1;
                    dfs(cnt+1);
                    graph[i][j]=0;
                }
            }
        }
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        copy = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]==2) q.offer(new int[] {j, i});
            }
        }

        for(int i=0; i<N; i++) copy[i] = graph[i].clone();

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
                if(copy[ny][nx]==0){
                    q.offer(new int[] {nx, ny});
                    copy[ny][nx] = 2;
                }
            }
        }

        int safe=0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copy[i][j]==0) safe++;
            }
        }

        max = Math.max(max, safe);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) graph[i][j] = Integer.parseInt(st.nextToken());        
        }

        dfs(0);

        System.out.println(max);
    }
}
