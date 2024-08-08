package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17394 {
    static class Node{
        int val, w;
        public Node(int val, int w){
            this.val = val;
            this.w = w;
        }
    }
    static boolean[] visited;
    static int N, A, B;

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        visited[N] = true;
        q.offer(new Node(N, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            int val = cur.val;
            int w = cur.w;

            if(val>=A && val<=B && isPrime(val)) return cur.w;

            for(int i=0; i<4; i++){
                int nval = val;
                switch(i){
                    case 0 : nval /= 2;
                        break;
                    case 1 : nval /= 3;
                        break;
                    case 2 : nval += 1;
                        break;
                    case 3 : nval -= 1;
                        break;
                }
                if(nval<=0 || nval>N || visited[nval]) continue;
                q.offer(new Node(nval, w+1));
                visited[nval] = true;
            }
        }
        return -1;
    }

    static boolean isPrime(int a){
        for(int i=2; i<=(int)Math.sqrt(a); i++){
            if(a%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            visited = new boolean[3000002];
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

  
            sb.append(bfs()).append("\n");
        }

        System.out.println(sb);
    }
}
