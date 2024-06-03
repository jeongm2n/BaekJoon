package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class Q3184 {
    static int R, C;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int rs = 0;
    static int rw = 0;

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[y][x] = true;

        int cs = 0;
        int cw = 0;

        if(graph[y][x]=='o') cs++;
        else if(graph[y][x]=='v') cw++;

        while(!q.isEmpty()){
            int[] data = q.poll();

            for(int i=0; i<4; i++){
                int nx = data[0] + dx[i];
                int ny = data[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<C && ny<R && !visited[ny][nx] && graph[ny][nx]!='#'){
                    if(graph[ny][nx]=='o') cs++;
                    else if(graph[ny][nx]=='v') cw++;
                    visited[ny][nx] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }

        if(cs>cw) rs += cs;
        else rw += cw;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            graph[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && graph[i][j]!='#') bfs(j, i);
            }
        }

        System.out.println(rs + " " + rw);
    }
}
