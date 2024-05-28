package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1937 {
    static int n;
    static int[][] graph; 
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int dfs(int x, int y){
        if(map[y][x]!=0) return map[y][x];

        map[y][x] = 1;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n){
                if(graph[ny][nx]>graph[y][x]){
                    map[y][x] = Math.max(map[y][x], dfs(nx, ny)+1);
                    dfs(nx, ny);
                }
            }
        }
        return map[y][x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        graph = new int[n][n];
        map = new int[n][n];
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                max = Math.max(max, dfs(j, i));        
            }
        }

        System.out.println(max);
    }
}
