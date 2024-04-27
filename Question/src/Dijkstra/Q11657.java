package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11657 {
    static class Node{
        int s;
        int d;
        int w;
        public Node(int s, int d, int w){
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    static Node[] graph;
    static long[] dist;
    static int n;
    static int m;
    static final int INF = Integer.MAX_VALUE;

    static boolean bellmanford(int start){
        dist[start] = 0;

        for(int i=1; i<=n; i++){
            for(int j=0; j<m; j++){ //모든 간선에 대해서 거리 계산
                Node node = graph[j];
                if(dist[node.s]==INF) continue;
                if(dist[node.d]>dist[node.s]+node.w){
                    dist[node.d] = dist[node.s] + node.w;
                    if(i==n) return true; //n번까지 dist[]의 값에 갱신이 있다면 음수 순환 부분이 있다는 뜻
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new Node[m];
        dist = new long[n+1];

        for(int i=1; i<=n; i++){
            dist[i] = INF;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[i] = new Node(a,b,c);
        }

        StringBuilder sb = new StringBuilder();
        if(bellmanford(1)) System.out.println(-1);
        else{
            for(int i=2; i<=n; i++){
                sb.append(dist[i]==INF ? -1 : dist[i]).append("\n");
            }
            System.out.println(sb);
        }
    }
}
