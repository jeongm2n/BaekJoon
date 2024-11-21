package BFS;

import java.io.*;
import java.util.*;

public class Q28069 {
    static class Node{
        int n, w;
        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }
    }
    static int N, K;

    static boolean bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        boolean result = false;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.w==K && cur.n==N){
                result = true;
                break;
            }

            for(int i=0; i<2; i++){
                int nn = 0;
                if(i==0) nn = cur.n+1;
                else if(i==1) nn = cur.n + (cur.n/2);

                if(nn>N) continue;
                q.offer(new Node(nn, cur.w+1));
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    
        System.out.println(!bfs() ? "water" : "minigimbob");
    }
}
