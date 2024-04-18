package Queue;
import java.util.*;

public class Q11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.offer(i);
        }
        sb.append("<");

        while(q.size()>1){
            for(int i=1; i<k; i++){
                int a = q.poll();
                q.offer(a);
            }
            sb.append(q.poll()+ ", ");
        }
        sb.append(q.poll()).append(">");
        System.out.print(sb);
    }
}
