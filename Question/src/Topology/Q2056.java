package Topology;

import java.io.*;
import java.util.*;

public class Q2056 {
    static ArrayList<Integer>[] graph;
    static int N, indegree[], time[], result[];
    static Queue<Integer> q = new LinkedList<>();

    static int topology(){    
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : graph[cur]){
                indegree[next]--;
                result[next] = Math.max(result[next], result[cur] + time[next]);
                if(indegree[next]==0) q.offer(next);
            }
        }

        int answer = 0;
        for(int i=1; i<=N; i++) answer = Math.max(answer, result[i]);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        indegree = new int[N+1];
        time = new int[N+1];
        result = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            result[i] = t;
            int m = Integer.parseInt(st.nextToken());

            for(int j=0; j<m; j++){
                int v = Integer.parseInt(st.nextToken());
                graph[v].add(i);
                indegree[i]++;
            }
        }

        for(int i=1; i<=N; i++) if(indegree[i]==0) q.offer(i);

        System.out.println(topology());
    }
}
