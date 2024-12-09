package BFS;

import java.io.*;
import java.util.*;

public class Q17220 {
    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int v : graph[cur]){
                if(!visited[v]){
                    q.offer(v);
                    visited[v] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        graph = new ArrayList[N];
        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();

        int[] head = new int[N];
        ArrayList<Integer> headList = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = st.nextToken().charAt(0) - 'A';
            int v = st.nextToken().charAt(0) - 'A';
            graph[u].add(v);
            head[v]++;
        }

        for(int i=0; i<N; i++){
            if(head[i]==0) headList.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        for(int i=0; i<S; i++) bfs(st.nextToken().charAt(0)-'A');

        int answer = 0;
        for(int i=0; i<N; i++){
            if(!visited[i]) answer++;
        }

        System.out.println(answer-headList.size());
    }
}
