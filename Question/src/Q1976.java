import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1976 {
    static ArrayList<Integer>[] graph;
    static int n;

    static boolean bfs(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int v = q.poll();

            for(int i : graph[v]){
                if(i==end) return true;
                if(!visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        graph = new ArrayList[n+1];

        for(int i=0; i<=n; i++) graph[i] = new ArrayList<Integer>();

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        boolean toor = true;

        for(int i=0; i<m-1; i++){
            int end = Integer.parseInt(st.nextToken());
            if(start==end) continue;
            if(!bfs(start,end)){
                toor = false;
                break;
            }
            start = end;
        }

        System.out.println(toor ? "YES" : "NO");
    }
}
