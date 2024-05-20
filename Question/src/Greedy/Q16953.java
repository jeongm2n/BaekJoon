package Greedy;

import java.util.*;

public class Q16953 {
    static int bfs(long a, long b){
        Queue<Long> q = new LinkedList<>();
        q.offer(a);
        int cnt = 0;

        while(!q.isEmpty()){
            int s = q.size();

            for(int i=0; i<s; i++){
                long tmp = q.poll();
                if(tmp==b) return cnt+1;
                if(tmp*2<=b) q.offer(tmp*2);
                if(tmp*10+1<=b) q.offer(tmp*10+1);
            }
            cnt++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        int result = bfs(a,b);

        System.out.println(result);
    }
}
