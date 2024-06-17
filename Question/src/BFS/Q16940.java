package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16940 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] input;

    static int bfs(){
        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        int idx = 1;

        while(!q.isEmpty()){
            int u = q.poll();
            hs.clear();

            for(int v : graph[u]){
                if(!visited[v]){
                    visited[v] = true;
                    hs.add(v);
                }
            }

            int size = hs.size();
            for(int i=idx; i<idx+size; i++){
                if(hs.contains(input[i]))  q.offer(input[i]);
                else return 0;
            }
            idx += size;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());   
            if(input[0]!=1){
                System.out.println(0);
                System.exit(0);
            } 
        }

        System.out.println(bfs());
    }   
}
