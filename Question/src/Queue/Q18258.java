package Queue;
import java.util.*;
import java.io.*;

public class Q18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int a = 0;
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "push":
                    a = Integer.parseInt(st.nextToken());
                    q.offer(a);
                    break;
                case "pop":
                    sb.append((q.isEmpty() ? -1 : q.poll())).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append((q.isEmpty() ? 1 : 0)).append("\n");
                    break;
                case "front":
                    sb.append((q.isEmpty() ? -1 : q.peek())).append("\n");
                    break;
                case "back":
                    sb.append((q.isEmpty() ? -1 : a)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
