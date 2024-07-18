package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2412 {
    static class Home{
        int x, y;
        public Home(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static int T;
    static ArrayList<Home> list = new ArrayList<>();
    static HashSet<Home> visited = new HashSet<>();

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.y==T) return cur.w;

            for(Home h : list){
                if(visited.contains(h)) continue;
                int a = Math.abs(cur.x-h.x);
                int b = Math.abs(cur.y-h.y);

                if(b<0 || b>=200001) continue;

                if(a<=2 && b<=2){
                    q.offer(new Node(h.x, h.y, cur.w+1));
                    visited.add(h);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Home(x, y));
        }

        Collections.sort(list, (o1,o2)->{
            if(o1.y==o2.y) return o1.x-o2.x;
            return o1.y-o2.y;
        });

        System.out.println(bfs());
    }
}
