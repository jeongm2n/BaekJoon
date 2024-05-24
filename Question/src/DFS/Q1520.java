package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1520 {
    static int[][] graph, dp;
    static boolean[][] visited;
    static int m, n;
    static int result = 0;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int dfs(int x, int y){
        if(x==n-1 && y==m-1){
            return 1;
        }

        if(dp[y][x] != -1) return dp[y][x];

        visited[y][x] = true;
        dp[y][x] = 0;
        int h = graph[y][x];

        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx>=0 && nx<n && ny>=0 && ny<m){
                if(!visited[ny][nx] && graph[ny][nx]<h){
                    dp[y][x] += dfs(nx,ny);
                }
            }
        }
        visited[y][x] = false;

        return dp[y][x];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); //세로
        n = Integer.parseInt(st.nextToken()); //가로

        graph = new int[m][n];
        dp = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int h = Integer.parseInt(st.nextToken());
                graph[i][j] = h;
                dp[i][j] = -1;
            }
        }

        int result = dfs(0,0);

        System.out.println(result);
    }
}
