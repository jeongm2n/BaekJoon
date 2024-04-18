package Queue;
import java.util.*;
import java.io.*;

public class Q24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        int[] arr = new int[n];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            if(arr[i]==0){
                dq.offer(a);
            }
        }
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            dq.addFirst(Integer.parseInt(st.nextToken()));
            sb.append(dq.pollLast()).append(" ");
        }
        System.out.print(sb);
    }
}
