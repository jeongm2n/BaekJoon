package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13913 {
    static int[] position = new int[100001];
    static int time;
    static boolean[] visited = new boolean[100001];

    static void bfs(int s, int k){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        time = 0;
        visited[s] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur==k) break;

            for(int i=0; i<3; i++){
                int nx = 0;
                if(i==0) nx = cur-1;
                if(i==1) nx = cur+1;
                if(i==2) nx = cur*2;

                if(nx>=0 && nx<=100000 && !visited[nx]){
                    q.offer(nx);
                    visited[nx] = true;
                    position[nx] = cur;
                }
            }
            time++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        if(n==k){
            sb.append(0).append("\n");
            sb.append(n);
        }else{
            bfs(n, k);

            Stack<Integer> s = new Stack<>();
            int after = k;
            s.push(k);

            while(after!=n){
                s.push(position[after]);
                after = position[after];
            }
            
            sb.append(time).append("\n");
            while(!s.isEmpty()){
                sb.append(s.pop() + " ");
            }
        }
        System.out.println(sb);
    }
}
