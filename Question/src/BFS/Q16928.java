package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16928 {
    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];
    static int[] cnt = new int[101];

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();

        visited[1] = true;
        q.offer(1);
        cnt[1] = 0;

        while(!q.isEmpty()){
            int num = q.poll();

            if(num==100){
                System.out.println(cnt[100]);
                break;
            }

            for(int i=1; i<=6; i++){
                int x = num + i;

                if(x<=100 && !visited[x]){
                    visited[x] = true;
                    if(board[x]!=0){
                        if(!visited[board[x]]){
                            q.offer(board[x]);
                            visited[board[x]] = true;
                            cnt[board[x]] = cnt[num] + 1;
                        }
                    }else{
                        q.offer(x);
                        cnt[x] = cnt[num] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n+m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a] = b;
        }

        bfs();
    }
}
