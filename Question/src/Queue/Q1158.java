package Queue;

import java.util.*;

public class Q1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++){
            q.offer(i);
        }
        
        sb.append("<");
        
        if(n==1) sb.append(1);
        else{
            while(!q.isEmpty()){
                for(int i=0; i<k-1; i++){
                    int a = q.poll();
                    q.offer(a);
                }
                if(q.size()==n) sb.append(q.poll()).append(",");
                else if(q.size()==1) sb.append(" ").append(q.poll());
                else sb.append(" ").append(q.poll()).append(",");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
