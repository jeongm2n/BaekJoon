package BFS;

import java.util.*;

public class Q1697 {
    static int[] visited; 
    static int cnt = 0;

    static void bfs(int start, int end){
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        visited[start] = 1;
        
        while(!q.isEmpty()){
            int v = q.poll();
            for(int i=0; i<3; i++){
                int next = 0;

                if(i==0) next = v-1;
                else if(i==1) next = v+1;
                else next = v*2;
                if(next==end){
                    System.out.println(visited[v]);
                    return;
                }
                if(next>=0 && next<=100000 && visited[next]==0){
                    visited[next] = visited[v] + 1;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        visited = new int[100001];

        int n = sc.nextInt();
        int k = sc.nextInt();

        if(n==k) System.out.println(0);
        else bfs(n,k);
    }
}
