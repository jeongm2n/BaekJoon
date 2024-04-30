package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1967 {
    static class Node{
        int child; int w;
        public Node(int child, int w){
            this.child = child;
            this.w = w;
        }
    }

    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max = 0;
    static int last = 0;

    public static void dfs(int start, int d){
        if(d>max){
            max = d;
            last = start;
        }

        visited[start] = true;

        for(Node node : tree[start]){
            if(!visited[node.child]){
                dfs(node.child, node.w + d);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        tree = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++) tree[i] = new ArrayList<Node>();

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, w));
            tree[child].add(new Node(parent, w));
        }

        dfs(1,0);

        visited = new boolean[n+1];
        dfs(last,0);

        System.out.println(max);
    }
}
