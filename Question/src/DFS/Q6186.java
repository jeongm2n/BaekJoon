package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6186 {
    static int R, C;
    static char[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;

    static void dfs(int x, int y){
        visited[y][x] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<C && ny<R){
                if(!visited[ny][nx] && graph[ny][nx]=='#'){
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            String s = br.readLine();
            graph[i] = s.toCharArray();
        }

        int cnt = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && graph[i][j]=='#'){
                    cnt++;
                    dfs(j, i);
                }
            }
        }

        System.out.println(cnt);
    }   
}
