package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2151 {
    static class Node{
        int x, y, dir, w;
        public Node(int x, int y, int dir, int w){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.w = w;
        }
    }

    static int N;
    static char[][] graph;
    static boolean[][][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int ex=0, ey=0;

    static int bfs(int sx, int sy){
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{return o1.w - o2.w;});
        
        for(int i=0; i<4; i++){ //0=상 1=하 2=좌 3=우
            q.offer(new Node(sx, sy, i, 0));
        }

        int result = 0;

        while(!q.isEmpty()){
            Node n = q.poll();

            int x = n.x;
            int y = n.y;
            int dir = n.dir;
            int w = n.w;

            visited[y][x][dir] = true;

            if(x==ex && y==ey){
                result = w;
                break;
            }
           
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(!visited[ny][nx][dir] && graph[ny][nx]!='*'){
                    if(graph[ny][nx]=='!') {
                        int r = (dir+3)%4;
                        int l = (dir+2)%4;

                        q.offer(new Node(nx, ny, r, w+1));
                        q.offer(new Node(nx, ny, l, w+1));
                    }
                    q.offer(new Node(nx, ny, dir, w));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N][4];

        int x=0, y=0;
        boolean first = true;
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                graph[i][j] = str.charAt(j);
                if(graph[i][j]=='#'){
                    if(first){
                        first = false;
                        x = j;
                        y = i;
                    }else{
                        ex = j;
                        ey = i;
                    }
                }
            }
        }

        System.out.println(bfs(x, y));
    }
}
