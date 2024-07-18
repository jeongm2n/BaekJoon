package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18513 {
    static class Node{
        int x, w;
        public Node(int x, int w){
            this.x = x;
            this.w = w;
        }
    }

    static int[] dx = {-1, 1};
    static Queue<Node> q = new LinkedList<>();
    static HashSet<Integer> visited = new HashSet<>();

    static long bfs(int K){
        int cnt = 0;
        long sum = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<2; i++){
                int nx = cur.x + dx[i];
                
                if(!visited.contains(nx)){
                    sum += cur.w+1;
                    visited.add(nx);
                    cnt++;

                    if(cnt==K) return sum;
                    q.offer(new Node(nx, cur.w+1));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(st.nextToken());
            visited.add(x);
            q.offer(new Node(x, 0));
        }

        System.out.println(bfs(K));
    }
}
