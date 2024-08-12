package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2021 {
    static ArrayList<Integer>[] line;
    static ArrayList<Integer>[] stat;
    static boolean[] visitedStat;
    static boolean[] visitedLine;
    static class Node{
        int d, l, w;
        public Node(int d, int l, int w){
            this.d = d;
            this.l = l;
            this.w = w;
        }
    }

    static int bfs(int s, int e){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});
        visitedStat[s] = true;

        for(int l : stat[s]){
            pq.offer(new Node(s, l, 0));
            visitedLine[l] = true;
        }

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.d == e) return cur.w;

            for(int d : line[cur.l]){
                if(!visitedStat[d]){
                    visitedStat[d] = true;
                    pq.offer(new Node(d, cur.l, cur.w));

                    for(int nextl : stat[d]){
                        if(!visitedLine[nextl]){
                            visitedLine[nextl] = true;
                            pq.offer(new Node(d, nextl, cur.w+1));
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        visitedStat = new boolean[N+1];
        visitedLine = new boolean[L+1];

        stat = new ArrayList[N+1];
        line = new ArrayList[L+1];
        
        for(int i=1; i<=N; i++) stat[i] = new ArrayList<>();
        for(int i=1; i<=L; i++) line[i] = new ArrayList<>();

        for(int i=1; i<=L; i++){
            st = new StringTokenizer(br.readLine());
            while(true){
                int a = Integer.parseInt(st.nextToken());
                if(a==-1) break;
                stat[a].add(i);
                line[i].add(a);
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        System.out.println(bfs(s, e));
    }
}
