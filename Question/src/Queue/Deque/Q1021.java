package Queue.Deque;

import java.io.*;
import java.util.*;

public class Q1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];

        LinkedList<Integer> dq = new LinkedList<>();

        for(int i=1; i<=N; i++) dq.offer(i);

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++) arr[i] = Integer.parseInt(st.nextToken());

        int result = 0;
        for(int i : arr){
            int idx = dq.indexOf(i);
            int mid = dq.size()%2==0 ? (dq.size()/2)-1 : dq.size()/2;

            if(idx<=mid){
                for(int j=0; j<idx; j++){
                    dq.offerLast(dq.pollFirst());
                    result++;
                }
            }else{
                for(int j=0; j<dq.size() - idx; j++){
                    dq.offerFirst(dq.pollLast());
                    result++;
                }
            }
            dq.pollFirst();
        }

        System.out.println(result);
    }   
}
