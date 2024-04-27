package Dijkstra;

import java.util.*;

public class Q13549 {
    static class Node{
        int x;
        int w;
        public Node(int x, int w){
            this.x = x;
            this.w = w;
        }
    }
    static int max = 100000;
    static int min = Integer.MAX_VALUE;

    public static void dijkstra(int n, int k){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.w-o2.w);
        boolean[] visited = new boolean[100001];
        
        pq.offer(new Node(n,0));
        visited[n] = true;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int x = node.x;
            int w = node.w;
            visited[x] = true;
            if(x==k) min = Math.min(min,w);
            //x좌표를 이동할 때 최대거리를 넘지 않고 이동할 좌표가 방문한적 없는 조건 설정
            if(x*2<=100000 && !visited[x*2]) pq.offer(new Node(x*2,w));
            if(x+1<=100000 && !visited[x+1]) pq.offer(new Node(x+1,w+1));
            if(x-1>=0 && !visited[x-1]) pq.offer(new Node(x-1,w+1));
        }

        System.out.println(min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if(n==k) System.out.println(0);
        else dijkstra(n,k);
    }
}
