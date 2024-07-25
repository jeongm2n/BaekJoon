package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q12852 {
    static class Node{
        int val, w;
        public Node(int val, int w){
            this.val = val;
            this.w = w;
        }
    }

    static boolean[] visited = new boolean[1000001];
    static int[] graph = new int[1000001];

    static int bfs(int N){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));
        visited[N] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int val = cur.val;

            if(val==1) return cur.w;

            if(val%3==0) val/=3;
            else if(val%2==0) val/=2;
            else val -= 1;
            graph[cur.val] = val;

            if(!visited[val]){
                q.offer(new Node(val, cur.w+1));
                visited[val] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(bfs(N)).append("\n");

        while(N!=1){
            sb.append(N + " ");
            N = graph[N];
        }
        sb.append(1);

        System.out.println(sb);
    }
}
