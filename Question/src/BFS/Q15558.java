package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15558 {
    static class Node{
        int x, y, t;
        public Node(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    static char[][] graph;
    static int N, k;
    static boolean[][] visited;

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0, 0));
        visited[0][1] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            int t = cur.t;

            int[] dx = {1, -1, cur.x+k};
            int[] dy = {cur.y, cur.y, 1-cur.y};

            for(int i=0; i<3; i++){
                int nx = cur.x + dx[i];
                int ny = dy[i];

                if(nx>=N) return 1;

                if(nx>t && !visited[ny][nx] && graph[ny][nx]!='0'){
                    q.offer(new Node(nx, ny, t+1));
                    visited[ny][nx] = true;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new char[2][N+1];
        visited = new boolean[2][N+1];
        for(int i=0; i<2; i++){
            String s = br.readLine();
            graph[i] = s.toCharArray();
        }

        System.out.println(bfs());
    }
}
