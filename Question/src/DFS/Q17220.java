package DFS;

import java.io.*;
import java.util.*;

public class Q17220 {
    static int N, M, answer=0;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static void dfs(int s){
        if(!visited[s]){
            for(int v : graph[s]){
                if(!visited[v]){
                    answer++;
                    dfs(v);
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

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = st.nextToken().charAt(0) - 'A';
            int v = st.nextToken().charAt(0) - 'A';
            graph[u].add(v);
            head[v]++;
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        for(int i=0; i<S; i++) visited[st.nextToken().charAt(0)-'A'] = true;

        for(int i=0; i<N; i++){
            if(head[i]==0) dfs(i);
        }

        System.out.println(answer);
    }
}
