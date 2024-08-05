package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17198 {
    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static char[][] graph = new char[10][10];
    static boolean[][] visited = new boolean[10][10];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int sx, sy, ex, ey;

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy, 0));
        visited[sy][sx] = true;
        int result = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x==ex && cur.y==ey){
                result = cur.w-1;
                break;
            }

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx>=0 && ny>=0 && nx<10 && ny<10 && !visited[ny][nx]){
                    if(graph[ny][nx]=='R') continue;
                    q.offer(new Node(nx, ny, cur.w+1));
                    visited[ny][nx] = true;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<10; i++){
            String s = br.readLine();
            for(int j=0; j<10; j++){
                graph[i][j] = s.charAt(j);
                if(graph[i][j]=='B'){
                    sx = j;
                    sy = i;
                }
                if(graph[i][j]=='L'){
                    ex = j;
                    ey = i;
                }
            }
        }

        System.out.println(bfs());
    }
}
