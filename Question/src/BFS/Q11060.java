package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11060 {
    static int[] graph;
    static int n;

    static class Node{
        int x, w;
        public Node(int x, int w){
            this.x = x;
            this.w = w;
        }
    }

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));

        while(!q.isEmpty()){
            Node node = q.poll();

            if(node.x==n-1) return node.w;

            for(int i=1; i<=graph[node.x]; i++){
                int nx = node.x + i;

                if(nx>=0 && nx<n){
                    q.offer(new Node(nx, node.w+1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            graph[i] = Integer.parseInt(st.nextToken());
        }

        int result = bfs();
        System.out.println(result);
    }
}
