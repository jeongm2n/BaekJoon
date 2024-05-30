package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2583 {
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int m, n;
    static int[][] graph;
    static boolean[][] visited;

    static int bfs(int y, int x){
        Queue<Node> q = new LinkedList<>();
        visited[y][x] = true;
        q.offer(new Node(x, y));

        int cnt = 1;
        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(!visited[ny][nx] && graph[ny][nx]==0){
                        visited[ny][nx] = true;
                        q.offer(new Node(nx, ny));
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken()); 

            for(int y=y1; y<y2; y++){
                for(int x=x1; x<x2; x++){
                    graph[y][x] = 1;
                }
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && graph[i][j]==0){
                    arr.add(bfs(i,j));
                }
            }
        }
        Collections.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        sb.append(arr.size()).append("\n");
        for(int i : arr){
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
