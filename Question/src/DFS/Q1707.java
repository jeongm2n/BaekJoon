package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1707 {
    static ArrayList<Integer>[] graph;
    static int red = 1;
    static int blue = -1;
    static int[] colors;
    static boolean check;

    static void dfs(int s, int color){
        colors[s] = color;

        for(int v : graph[s]){
            if(colors[v]==color){
                check = false;
                return;
            }
            if(colors[v]==0) dfs(v, color*(-1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int z=0; z<K; z++){
            st = new StringTokenizer(br.readLine());
            
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            check = true;

            graph = new ArrayList[V+1];
            colors = new int[V+1];

            for(int i=1; i<=V; i++){
                graph[i] = new ArrayList<Integer>();
                colors[i] = 0;
            }

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            for(int i=1; i<=V; i++){
                if(!check) break;
                if(colors[i]==0) dfs(i, red);
            }

            sb.append(check ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
