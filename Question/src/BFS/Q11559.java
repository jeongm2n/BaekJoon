package BFS;

import java.io.*;
import java.util.*;

public class Q11559 {
    static final int N = 12, M = 6;
    static char[][] graph = new char[N][M];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int answer = 0;
    static boolean isPop;

    static class Node{
        int x, y;
        char c;
        public Node(int x, int y, char c){
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        ArrayList<int[]> arr = new ArrayList<>();

        visited[y][x] = true;
        q.offer(new Node(x, y, graph[y][x]));
        arr.add(new int[] {x, y});

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx<0 || ny<0 || nx>=M || ny>=N || visited[ny][nx]) continue;

                if(graph[ny][nx]==cur.c){
                    q.offer(new Node(nx, ny, cur.c));
                    visited[ny][nx] = true;
                    arr.add(new int[] {nx, ny});
                }
            }
        }

        if(arr.size() >= 4) {
            for(int i=0; i<arr.size(); i++){
                int[] data = arr.get(i);
                x = data[0];
                y = data[1];

                graph[y][x] = '.';
            }
            isPop = true;
        }
    }

    static void floor(){
        for(int i=0; i<N-1; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]!='.' && graph[i+1][j]=='.'){
                    graph[i+1][j] = graph[i][j];
                    graph[i][j] = '.';
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++) graph[i][j] = str.charAt(j);
        }

        while(true){
            isPop = false;

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(graph[i][j]!='.') bfs(j, i);
                }
            }

            floor();

            if(!isPop) break;
            answer++;
        }

        System.out.println(answer);
    }
}
