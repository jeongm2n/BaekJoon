package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {
    static int N;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static int cnt;

    static void dfs(int x, int y, int h){
        visited[y][x] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;

            if(!visited[ny][nx] && graph[ny][nx]>h){
                dfs(nx, ny, h);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        graph = new int[N][N];

        int maxh = -1;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxh = Math.max(graph[i][j], maxh);
            }
        }

        int result = -1;

        for(int h=0; h<=maxh; h++){
            cnt = 0;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && graph[i][j]>h){
                        cnt++;
                        dfs(j, i, h);
                    }
                }
            }
            result = Math.max(cnt, result);
        }

        System.out.println(result);
    }
}
