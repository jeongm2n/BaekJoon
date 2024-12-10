package BFS;

import java.io.*;
import java.util.*;

public class Q27440 {
    static class Node{
        long val;
        int w;
        public Node(long val, int w){
            this.val = val;
            this.w = w;
        }
    }

    static long N;
    static HashSet<Long> visited;

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N,0));
        visited.add(N);
        int result = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            long val = cur.val;
            int w = cur.w;

            if(val==1){
                result = cur.w;
                break;
            }

            if(val%3==0 && !visited.contains(val/3)){
                q.offer(new Node(val/3, w+1));
                visited.add(val/3);
            }
            if(val%2==0 && !visited.contains(val/2)){
                q.offer(new Node(val/2, w+1));
                visited.add(val/2);
            }
            if(!visited.contains(val-1)){
                q.offer(new Node(val-1, w+1));
                visited.add(val-1);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        visited = new HashSet<>();

        //if(N==1) System.out.println(0);
        System.out.println(bfs());
    }   
}
