package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16397 {
    static class Node{
        int val, cnt;
        public Node(int val, int cnt){
            this.val = val;
            this.cnt = cnt;
        }
    }

    static int[] graph = new int[100000];
    static boolean[] visited = new boolean[100000];

    static void bfs(int N, int T, int G){
        Queue<Node> q = new LinkedList<>();
        visited[N] = true;
        q.offer(new Node(N, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.cnt>T) return;

            if(cur.val==G){
                System.out.println(cur.cnt);
                System.exit(0);
            }

            int next = cur.val + 1;
            if(check(next)){
                q.offer(new Node(next, cur.cnt+1));
                visited[next] = true;
            }
            
            if(cur.val==0) continue;
            next = cur.val * 2;
            if(next<=99999){
                int temp = (int)Math.pow(10, (int) Math.log10(next));
                next-=temp;
                if(check(next)){
                    q.offer(new Node(next, cur.cnt+1));
                    visited[next] = true;
                }
            }
        }
    }

    static boolean check(int x){
        if(x>=0 && x<=99999 && !visited[x]) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        bfs(N, T, G);
        System.out.println("ANG");
    }
}
