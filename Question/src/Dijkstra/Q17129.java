package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17129 {
    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n, m;
    static Queue<Node> q = new LinkedList<>();

    static int bfs(){
        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx>=0 && ny>=0 && nx<m && ny<n){
                    if(!visited[ny][nx] && graph[ny][nx]!=1){
                        if(graph[ny][nx]!=0) return cur.w+1;
                        q.offer(new Node(nx, ny, cur.w+1));
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j] = s.charAt(j)-'0';
                if(graph[i][j]==2){
                    q.offer(new Node(j, i , 0));
                    visited[i][j] = true;
                }
            }
        }

        int result = bfs();

        if(result==0) System.out.println("NIE");
        else{
            System.out.println("TAK");
            System.out.println(result);
        }
    }
}
