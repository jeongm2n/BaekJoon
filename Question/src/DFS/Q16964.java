package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16964 {
    static ArrayList<Integer>[] graph;
    static int N;
    static int[] input;
    static boolean[] visited;
    static HashSet<Integer> hs;
    static int idx = 1;

    static void dfs(int s){
        visited[s] = true;
        hs = new HashSet<>();

        for(int v : graph[s]){
            if(!visited[v]) hs.add(v);
        }

        if(hs.size()==0) return;
        if(!hs.contains(input[idx])){
            System.out.println(0);
            System.exit(0);
        }

        dfs(input[idx++]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        input = new int[N];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) input[i] = Integer.parseInt(st.nextToken());

        if(input[0]!=1){
            System.out.println(0);
            System.exit(0);
        }

        dfs(1);

        System.out.println(1);

    }
}
