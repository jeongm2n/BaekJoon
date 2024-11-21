package BFS;

import java.io.*;
import java.util.*;

public class Q28069 {
    static int N, K;
    static int[] dp;

    static boolean bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()){
            int cur = q.poll();

            if(dp[cur]==K && cur==N) return true;

            for(int i=0; i<2; i++){
                int nn = 0;
                if(i==0) nn = cur+1;
                else if(i==1) nn = cur + (cur/2);

                if(nn>N || dp[nn]!=0) continue;
                q.offer(nn);
                dp[nn] = dp[cur] + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        dp = new int[N+1];

        System.out.println(!bfs() ? "water" : "minigimbob");
    }
}
