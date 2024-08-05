package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14226 {
    static class Display{
        int val, board, t;
        public Display(int val, int board, int t){
            this.val = val;
            this.board = board;
            this.t = t;
        }
    }
    static boolean[][] visited;

    static int bfs(int S){
        Queue<Display> q = new LinkedList<>();
        q.offer(new Display(1, 0, 0));
        int result = 0;
        visited[0][1] = true;

        while(!q.isEmpty()){
            Display cur = q.poll();

            int val = cur.val;
            int board = cur.board;
            int t = cur.t;

            if(val == S){
                result = t;
                break;
            }

            q.offer(new Display(val, val, t+1));

            if(cur.board!=0 && val+board<=S && !visited[board][val+board]){
                q.offer(new Display(val + board, board, t+1));
                visited[board][val+board] = true;
            }
            if(val!=0 && !visited[board][val-1]) {
                q.offer(new Display(val-1, board, t+1));
                visited[board][val-1] = true;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        
        visited = new boolean[1001][1001];
        System.out.println(bfs(S));
    }   
}
