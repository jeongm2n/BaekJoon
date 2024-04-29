package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1167 {
    static class Node{
        int v; int w;
        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Node>[] tree;
    static int max = 0;
    static int last;

    public static void dfs(int start, int d){
        if(d > max){
            max = d;
            last = start;
        }

        visited[start] = true;

        for(Node node : tree[start]){
            if(!visited[node.v]){
                dfs(node.v, d + node.w);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n+1];
        dist = new int[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++){
            tree[i] = new ArrayList<Node>();
        }

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());

            while(true){
                int v = Integer.parseInt(st.nextToken());
                if(v==-1) break;
                int w = Integer.parseInt(st.nextToken());

                tree[u].add(new Node(v,w));
            }
        }

        dfs(1,0);

        visited = new boolean[n+1];
        dfs(last,0);

        System.out.println(max);
    }
}
