package Queue;
import java.util.*;

public class Q2346 {
    public static class Balloon{
        private int idx;
        private int val;

        Balloon(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Deque<Balloon> dq = new ArrayDeque<>();

        for(int i=1; i<=n; i++){
            int a = sc.nextInt();
            Balloon balloon = new Balloon(i, a);
            dq.offer(balloon);
        }
        Balloon k = dq.poll();
        sb.append(1).append(" ");
        while(!dq.isEmpty()){
            if(k.val>0){
                for(int i=0; i<k.val-1; i++){
                    Balloon tmp = dq.poll();
                    dq.offer(tmp);
                }
                k = dq.poll();
            }else{
                for(int i=0; i<Math.abs(k.val)-1; i++){
                    Balloon tmp = dq.pollLast();
                    dq.offerFirst(tmp);
                }
                k = dq.pollLast();
            }
            sb.append(k.idx).append(" ");
        }
        System.out.print(sb);
    }
}
