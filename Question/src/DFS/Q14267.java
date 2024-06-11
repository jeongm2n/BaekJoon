package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14267 {
    static ArrayList<Integer>[] graph;
    static int[] praise;

    static void dfs(int s){
        for(int num : graph[s]){
            praise[num] += praise[s];
            dfs(num);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        praise = new int[n+1];

        for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent==-1) continue;
            graph[parent].add(i);
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            praise[u] += w;
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(praise[i] + " ");
        }

        System.out.println(sb);
    }
}
