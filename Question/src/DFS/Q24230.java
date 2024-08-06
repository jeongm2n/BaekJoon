package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q24230 {
    static ArrayList<Integer>[] graph;
    static int[] color;

    static int dfs(int s, int parent){
        int cnt = color[s] == color[parent] ? 0 : 1;

        for(int v : graph[s]){
            if(v==parent) continue;
            cnt += dfs(v, s);
        }
        return cnt;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N+1];
        color = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
            color[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println(dfs(1, 0));
    }
}
