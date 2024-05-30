package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1303 {
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int bfs(int x, int y, char c){
        Queue<Node> q = new LinkedList<>();
        visited[y][x] = true;
        q.offer(new Node(x, y));
        int w = 1;

        while(!q.isEmpty()){
            Node n = q.poll();

            for(int i=0; i<4; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(!visited[ny][nx] && graph[ny][nx]==c){
                        visited[ny][nx] = true;
                        q.offer(new Node(nx, ny));
                        w++;
                    }
                }
            }
        }
        return w*w;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++){
            graph[i] = br.readLine().toCharArray();
        }

        int rw = 0;
        int rb = 0;

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    if(graph[i][j]=='W') rw += bfs(j, i, 'W');
                    if(graph[i][j]=='B') rb += bfs(j, i, 'B');
                }
            }
        }

        System.out.println(rw + " " + rb);

    }
}
