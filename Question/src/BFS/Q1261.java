package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1261 {
    static class Node{
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int bfs(int r, int c){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.cnt - o2.cnt;
        });
        visited[1][1] = true;
        pq.offer(new Node(1, 1, 0));
        int result = 0;

        while(!pq.isEmpty()){
            Node n = pq.poll();

            if(n.x==c && n.y==r) {
                result = n.cnt;
                break;
            }

            for(int i=0; i<4; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx>=1 && nx<=c && ny>=1 && ny<=r){
                    if(!visited[ny][nx]){
                        visited[ny][nx] = true;
                        if(graph[ny][nx]==0) pq.offer(new Node(nx, ny, n.cnt));
                        else pq.offer(new Node(nx, ny, n.cnt+1));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new int[r+1][c+1];
        visited = new boolean[r+1][c+1];

        for(int i=1; i<=r; i++){
            String s = br.readLine();
            for(int j=1; j<=c; j++){
                graph[i][j] = s.charAt(j-1)-'0';
            }
        }

        System.out.println(bfs(r, c));

    }
}
