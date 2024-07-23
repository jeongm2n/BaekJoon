package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13265 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] color;
    static boolean possible;

    static void dfs(int s){
        if(!possible) return;

        for(int i : graph[s]){
            if(color[i]==0){
                color[i] = 3 - color[s];
                dfs(i);
            }
            else if(color[i]==color[s]){
                possible = false;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            possible = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];
            color = new int[N+1];
            for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            for(int i=1; i<=N; i++){
                if(!possible) break;
                if(color[i]==0){
                    color[i] = 1;
                    dfs(i);
                }
            }

            sb.append(!possible ? "impossible" : "possible").append("\n");
        }

        System.out.println(sb);
    }
}
