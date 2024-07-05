package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q4963 {
    static int w, h;
    static int[][] graph;
    static int[] dx = {0,0,-1,1,-1,-1,1,1};
    static int[] dy = {-1,1,0,0,-1,1,-1,1};
    static boolean[][] visited;

    static void dfs(int x, int y){
        visited[y][x] = true;

        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<w && ny<h){
                if(!visited[ny][nx] && graph[ny][nx]==1){
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0) break;

            graph = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && graph[i][j]==1){
                        cnt++;
                        dfs(j, i);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
