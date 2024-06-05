package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1388 {
    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] data = q.poll();
            x = data[0];
            y = data[1];

            if(graph[y][x]=='-'){
                for(int i=2; i<4; i++){
                    int nx = x + dx[i];
                    
                    if(nx>=0 && nx<M && !visited[y][nx]){
                        if(graph[y][nx]=='-'){
                            q.offer(new int[] {nx, y});
                            visited[y][nx] = true;
                        }
                    }
                }
            }
            if(graph[y][x]=='|'){
                for(int i=0; i<2; i++){
                    int ny = y + dy[i];

                    if(ny>=0 && ny<N && !visited[ny][x]){
                        if(graph[ny][x]=='|') {
                            q.offer(new int[] {x, ny});
                            visited[ny][x] = true;
                        }
                    }
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            graph[i] = br.readLine().toCharArray();
        }

        int cnt = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]) cnt += bfs(j, i);
            }
        }
        System.out.println(cnt);
    }
}
