package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q12761 {
    static class Node{
        int val, cnt;
        public Node(int val, int cnt){
            this.val = val;
            this.cnt = cnt;
        }
    }

    static boolean[] visited = new boolean[100001];

    static int bfs(int a, int b, int s, int e){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s, 0));
        visited[s] = true;
        long[] res = new long[8];
        int result = 0;

        while(!q.isEmpty()){
            Node n = q.poll();

            if(n.val==e){
                result = n.cnt;
                break;
            }

            res[0] = n.val+1;
            res[1] = n.val-1;
            res[2] = n.val+a;
            res[3] = n.val-a;
            res[4] = n.val+b;
            res[5] = n.val-b;
            res[6] = n.val*a;
            res[7] = n.val*b;

            for(int i=0; i<8; i++){
                if(range(res[i]) && !visited[(int)res[i]]){
                    visited[(int)res[i]] = true;
                    q.offer(new Node((int)res[i], n.cnt+1));
                }
            }
        }

        return result;
    }
    
    static boolean range(long x){
        if(x>=1 && x<=100000) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a, b, n, m));

    }
}
