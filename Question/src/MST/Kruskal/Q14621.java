package MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14621 {
    static class Node{
        int u, v, w;
        public Node(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    static int[] parent;
    static String[] gender;
    static boolean[] connected;
    static ArrayList<Node> list = new ArrayList<>();
    
    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x>y) parent[x] = y;
        else parent[y] = x;
    }

    static int kruskal(){
        int cost = 0;

        for(Node n : list){
            int u = n.u;
            int v = n.v;
            int w = n.w;

            if(gender[u].equals(gender[v])) continue;
            if(find(u)==find(v)) continue;
            union(u, v);
            connected[u] = true;
            connected[v] = true;
            cost += w;
        }
        return cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        gender = new String[n+1];
        parent = new int[n+1];
        connected = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            parent[i] = i;
            gender[i] = st.nextToken();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Node(u, v, w));
        }
        Collections.sort(list, (o1,o2)->{return o1.w-o2.w;});

        int result = kruskal();

        for(int i=1; i<=n; i++){
            if(!connected[i]) result = -1;
        }

        System.out.println(result);
    }
}
