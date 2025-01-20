package DFS;

import java.io.*;
import java.util.*;

public class Q13023 {
    static int N, M, result=0;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int s, int depth){
        if(depth == 4){
            result = 1;
            return;
        }

        visited[s] = true;

        for(int v : graph[s]){
            if(!visited[v]){
                dfs(v, depth+1);
            }
        }
        
        visited[s] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=0; i<N; i++){
            if(result==0) dfs(i,0);
            else break;
        }

        System.out.println(result);
    }   
}
