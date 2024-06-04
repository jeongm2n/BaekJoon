package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16946 {
    static int N, M;
    static char[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[] {x, y});
        int cnt = 1;

        while(!q.isEmpty()){
            int[] spot = q.poll();

            for(int i=0; i<4; i++){
                int nx = spot[0] + dx[i];
                int ny = spot[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<M && ny<N){
                    if(!visited[ny][nx] && graph[ny][nx]=='0'){
                        visited[ny][nx] = true;
                        q.offer(new int[] {nx, ny});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            graph[i] = s.toCharArray();
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]=='1') {
                    int r = bfs(j, i);
                    sb.append(r%10);
                    continue;
                }
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
