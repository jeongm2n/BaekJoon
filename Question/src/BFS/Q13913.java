package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13913 {
    static int[] position = new int[100001];
    static int[] time = new int[100001];

    static void bfs(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        time[n] = 1;

        while(!q.isEmpty()){
            int s = q.poll();

            if(s==k) break;

            if(s-1>=0 && time[s-1]==0){
                q.offer(s-1);
                position[s-1] = s;
                time[s-1] = time[s]+1;
            }
            if(s+1<=100000 && time[s+1]==0){
                q.offer(s+1);
                position[s+1] = s;
                time[s+1] = time[s]+1;
            }
            if(s*2<=100000 && time[s*2]==0){
                q.offer(s*2);
                position[s*2] = s;
                time[s*2] = time[s*2]+1;
            }
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
            
            sb.append(s.size()-1).append("\n");
            while(!s.isEmpty()){
                sb.append(s.pop() + " ");
            }

            System.out.println(sb);
        }
    }
}
