package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14395 {
    static class Node{
        long val;
        String com;
        public Node(long val, String com){
            this.val = val;
            this.com = com;
        }
    }
    static boolean[] visited;

    static boolean bfs(int s, int t){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s, ""));
        visited[s] = true;
        long[] cal = new long[4];
        char[] command = {'*', '+', '-', '/'};

        while(!q.isEmpty()){
            Node n = q.poll();

            if(n.val==t){
                System.out.println(n.com);
                System.exit(0);
            }

            cal[0] = n.val*n.val;
            cal[1] = n.val+n.val;
            cal[2] = n.val-n.val;
            cal[3] = n.val/n.val;

            for(int i=0; i<4; i++){
                if(i==3){
                    if(cal[i]==0) break;
                }
                if(range(cal[i]) && !visited[(int)cal[i]]){
                    q.offer(new Node(cal[i], n.com + command[i]));
                    visited[(int)cal[i]] = true;
                }
            }
        }
        return false;
    }

    static boolean range(long x){
        if(x>=1 && x<=1000000000) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        if(s==t) {
            System.out.println(0);
            System.exit(0);
        }

        visited = new boolean[1000000001];
        boolean result = bfs(s, t);

        if(!result) System.out.println(-1);
    }
}
