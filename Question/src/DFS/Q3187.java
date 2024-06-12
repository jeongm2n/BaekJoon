package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3187 {
    static int R, C;
    static char[][] graph;
    static boolean[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int s, w;

    static void dfs(int x, int y){
        visited[y][x] = true;
        if(graph[y][x]=='k') s++;
        else if(graph[y][x]=='v') w++;

        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx>=0 && ny>=0 && nx<C && ny<R && !visited[ny][nx] && graph[ny][nx]!='#') dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited  = new boolean[R][C];

        for(int i=0; i<R; i++){
            graph[i] = br.readLine().toCharArray();
        }

        int rs = 0;
        int rw = 0;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && graph[i][j]!='#'){
                    s = 0;
                    w = 0;

                    dfs(j, i);

                    if(s>w) rs+=s;
                    else rw+=w;
                }
            }
        }

        System.out.println(rs + " " + rw);
    }
}
