package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16437 {
    static class Island{
        char kind;
        long val;
        public Island(char kind, long val){
            this.kind = kind;
            this.val = val;
        }
    }

    static ArrayList<Integer>[] graph;
    static Island[] islands;
    static int N;

    static long dfs(int v){
        long sum = 0;
        for(int i : graph[v]) sum += dfs(i);

        if(islands[v].kind=='S') return sum + islands[v].val;
        else{
            if(sum>islands[v].val) return sum - islands[v].val;
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        islands = new Island[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        islands[1] = new Island('S', 0);

        for(int i=2; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            char kind = st.nextToken().charAt(0);
            int val = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph[v].add(i);
            islands[i] = new Island(kind, val);
        }

        System.out.println(dfs(1));
    }
}
