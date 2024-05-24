package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3055 {
    static class Node{
        int x;
        int y;
        int m;

        public Node(int x, int y, int m){
            this.x = x;
            this.y = y;
            this.m = m;
        }
    }

    static char[][] graph;
    static boolean[][] visited;
    static Node bieber;
    static Queue<Node> go = new LinkedList<>();
    static Queue<Node> w = new LinkedList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int r, c;
    static int result = 0;

    static void bfs(){
        while(!go.isEmpty()){
            int size = w.size();

            for(int j=0; j<size; j++){
                Node n = w.poll();

                for(int i=0; i<4; i++){
                    int nx = n.x + dx[i];
                    int ny = n.y + dy[i];

                    if(nx>=0 && nx<c && ny>=0 && ny<r){
                        if(graph[ny][nx]=='.' && !visited[ny][nx]){
                            visited[ny][nx] = true;
                            w.offer(new Node(nx, ny, 0));
                            graph[ny][nx] = '*';
                        }
                    }
                }
            }

            size = go.size();
            
            for(int j=0; j<size; j++){
                Node n = go.poll();

                for(int i=0; i<4; i++){
                    int nx = n.x + dx[i];
                    int ny = n.y + dy[i];

                    if(nx>=0 && nx<c && ny>=0 && ny<r){
                        if(graph[ny][nx]=='D'){
                            result = n.m+1;
                            return;
                        }
                        if(graph[ny][nx]=='.' && !visited[ny][nx]){
                            visited[ny][nx] = true;
                            go.offer(new Node(nx, ny, n.m+1));
                        }
                    }
                }
            }
            
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        visited = new boolean[r][c];

        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                graph[i][j] = s.charAt(j);
                if(graph[i][j]=='D') bieber = new Node(j, i, 0);
                if(graph[i][j]=='S') go.offer(new Node(j, i, 0));
                if(graph[i][j]=='*') w.offer(new Node(j, i, 0));
            }
        }

        bfs();

        System.out.println(result==0 ? "KAKTUS" : result);
    }   
}
