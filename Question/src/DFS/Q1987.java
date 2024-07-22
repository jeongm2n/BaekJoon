package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1987 {
    static char[][] graph;
    static boolean[] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int r, c, max=0;

    static void dfs(int x, int y, int cnt){
        visited[graph[y][x]-'A'] = true;
        max = Math.max(max, cnt);

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<c && ny>=0 && ny<r){
                if(visited[graph[ny][nx]-'A']) continue;
                dfs(nx, ny, cnt+1);
                visited[graph[ny][nx]-'A'] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        visited = new boolean[26];

        for(int i=0; i<r; i++){
            graph[i] = (br.readLine()).toCharArray();
        }

        dfs(0,0,1);

        System.out.println(max);
    }   
}
