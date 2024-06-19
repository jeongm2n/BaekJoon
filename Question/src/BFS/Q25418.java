package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q25418 {
    static class Node{
        int val, w;
        public Node(int val, int w){
            this.val = val;
            this.w = w;
        } 
    }

    static int[] graph;
    static boolean[] visited;

    static int bfs(int s, int e){
        Queue<Node> q = new LinkedList<>();
        visited[s] = true;
        q.offer(new Node(s, 0));
        int result = 0;

        while(!q.isEmpty()){
            Node n = q.poll();

            if(n.val == e){
                result = n.w;
                break;
            }

            int[] data = new int[2];
            data[0] = n.val + 1;
            data[1] = n.val * 2;

            for(int i=0; i<2; i++){
                if(check(data[i]) && !visited[data[i]]){
                    visited[data[i]] = true;
                    q.offer(new Node(data[i], n.w+1));
                }
            }
        }

        return result;
    }

    static boolean check(int x){
        if(x>=1 && x<=1000000) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new int[1000001];
        visited = new boolean[1000001];

        int result = bfs(A, K);
        System.out.println(result);
    }   
}
