package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1926 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n, m, wide;
    static int max = 0;

    static void dfs(int x, int y){
        max = Math.max(max, wide);

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<m && ny>=0 && ny<n){
                if(!visited[ny][nx] && graph[ny][nx]==1){
                    wide++;
                    visited[ny][nx] = true;
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && graph[i][j]==1){
                    visited[i][j] = true;
                    wide = 1;
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(cnt).append("\n");
        sb.append(max).append("\n");

        System.out.println(sb);
    }
}
