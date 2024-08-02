package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q27211 {
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int R, C;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x ,y));
        visited[y][x] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = rangeX(cur.x + dx[i]);
                int ny = rangeY(cur.y + dy[i]);

                if(!visited[ny][nx] && graph[ny][nx]==0){
                    q.offer(new Node(nx, ny));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    static int rangeX(int a){
        if(a<0) return C-1;
        else if(a>=C) return 0;
        return a; 
    }
    
    static int rangeY(int a){
        if(a<0) return R-1;
        else if(a>=R) return 0;
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        visited  = new boolean[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && graph[i][j]==0){
                    bfs(j, i);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }   
}
