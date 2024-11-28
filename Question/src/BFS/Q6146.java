package BFS;

import java.io.*;
import java.util.*;

public class Q6146 {
    static int N;
    static boolean[][] visited = new boolean[1001][1001];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(500, 500, 0));
        visited[500][500] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x==x && cur.y==y) return cur.w;

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx<0 || ny<0 || nx>=1001 || ny>=1001 || visited[ny][nx]) continue;
                q.offer(new Node(nx, ny, cur.w+1));
                visited[ny][nx] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int y = Integer.parseInt(st.nextToken()) + 500;
        int x = Integer.parseInt(st.nextToken()) + 500;
        N = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken()) + 500;
            int A = Integer.parseInt(st.nextToken()) + 500;

            visited[B][A] = true; 
        }

        System.out.println(bfs(x, y));
    }
}
