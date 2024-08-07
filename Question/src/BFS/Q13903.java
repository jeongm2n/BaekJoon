package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13903 {
    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    static int R, C, N;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx, dy;

    static int bfs(int x, int y){
        visited = new boolean[R][C];
        Queue<Node> q = new LinkedList<>();
        visited[y][x] = true;
        q.offer(new Node(x, y, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.y==R-1) return cur.w;

            for(int i=0; i<N; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx>=0 && ny>=0 && nx<C && ny<R && !visited[ny][nx] && graph[ny][nx]==1){
                    q.offer(new Node(nx, ny, cur.w+1));
                    visited[ny][nx] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new int[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        N = Integer.parseInt(br.readLine());
        dx = dy = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            dy[i] = Integer.parseInt(st.nextToken());
            dx[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<C; i++){
            if(graph[0][i]==1) {
                int result = bfs(i, 0);
                if(result!=-1) ans.add(result); 
            }
        }

        if(ans.size()==0){
            System.out.println(-1);
            System.exit(0);
        }

        Collections.sort(ans);
        System.out.println(ans.get(0));
    }
}
