package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q25195 {
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> gom = new ArrayList<>();
    static boolean m = false;

    static void dfs(int s){
        if(m || gom.contains(s)) return;
        if(graph[s].isEmpty()){
            m = true;
            return;
        }

        for(int v : graph[s]) dfs(v);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
        }

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) gom.add(Integer.parseInt(st.nextToken()));

        dfs(1);

        System.out.println(m ? "yes" : "Yes");
    }
}
