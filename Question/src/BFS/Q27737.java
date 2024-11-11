package BFS;

import java.io.*;
import java.util.*;

public class Q27737 {
    static int N, M, K;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] graph;
    static boolean[][] visited;

    static int dfs(int x, int y){
        visited[y][x] = true;
        int cnt = 1;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx<0 || nx>=N || ny<0 || ny>=N || visited[ny][nx] || graph[ny][nx]==1) continue;
            cnt += dfs(nx, ny);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int total = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(graph[i][j]==0 && !visited[i][j]){
                    int tmp = dfs(j, i);
                    result += (tmp+K-1)/K;
                    total += tmp;
                }
            }
        }

        if(total == 0){
            System.out.println("IMPOSSIBLE");
            return;
        }

        if(result < M) {
        	System.out.println("POSSIBLE");
        	System.out.println(M-result);
        }
        else {
        	System.out.println("IMPOSSIBLE");
        }
    }
}
