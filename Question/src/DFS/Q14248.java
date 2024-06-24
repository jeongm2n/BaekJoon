package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14248 {
    static int graph[];
    static boolean[] visited;
    static int[] dx = {-1, 1};
    static int N;
    static int result = 0;

    static void dfs(int s){
        visited[s] = true;

        for(int i=0; i<2; i++){
            int nx = (dx[i]*graph[s])+s;

            if(nx>0 && nx<=N && !visited[nx]){
                result++;
                dfs(nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        graph = new int[N+1];
        visited = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) graph[i] = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine());

        dfs(s);
        System.out.println(result+1);
    }
}
