package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11123 {
    static char[][] graph;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static void dfs(int x, int y){
        visited[y][x] = true;
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
            if(!visited[ny][nx] && graph[ny][nx]=='#') dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(T>0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            graph = new char[n][m];
            visited = new boolean[n][m];

            for(int i=0; i<n; i++){
                graph[i] = br.readLine().toCharArray();
            }
            
            int result = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(!visited[i][j] && graph[i][j]=='#'){
                        result++;
                        dfs(j, i);
                    }
                }
            }
            sb.append(result).append("\n");
            T--;
        }
        System.out.println(sb);
    }   
}
