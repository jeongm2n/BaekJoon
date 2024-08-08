package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q26169 {
    static int[][] graph = new int[5][5];
    static int[][] map = new int[5][5];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int result = 0;

    static void dfs(int x, int y, int d, int a){
        if(graph[y][x]==1) a++;

        if(d==3){
            if(a>=2) result = 1;
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<5 && ny<5 && graph[ny][nx]!=-1){
                graph[y][x] = -1;
                dfs(nx, ny, d+1, a);
                graph[y][x] = map[y][x];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                graph[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
                
            }
        }
        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());

        dfs(sx, sy, 0, 0);

        System.out.println(result);
    }
}
