package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2573 {
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] graph;
    static boolean[][] visited;
    static int r, c;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static void bfs(){
        visited = new boolean[r][c];
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(graph[i][j]!=0 && !visited[i][j]){
                    q.offer(new Node(j, i));
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Node n = q.poll();

            int sea = 0;
            for(int i=0; i<4; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx>=0 && nx<c && ny>=0 && ny<r){
                    if(!visited[ny][nx] && graph[ny][nx]==0) sea++;
                }
            }

            if(graph[n.y][n.x] - sea < 0) graph[n.y][n.x] = 0;
            else graph[n.y][n.x] -= sea;
        }
    }

    static void dfs(int x, int y, boolean[][] visited){
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<c && ny>=0 && ny<r){
                if(graph[ny][nx]!=0 && !visited[ny][nx]) dfs(nx, ny, visited);
            }
        }
    }

    static int check(){
        visited = new boolean[r][c];

        int cnt = 0;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(graph[i][j]!=0 && !visited[i][j]){
                    dfs(j, i, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new int[r][c];

        for(int i=0; i<r; i++){ 
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt;
        int result = 0;

        while((cnt=check())<2){
            if(cnt==0){
                result = 0;
                break;
            }
            bfs();
            result++;
        }

        System.out.println(result);
    }
}
