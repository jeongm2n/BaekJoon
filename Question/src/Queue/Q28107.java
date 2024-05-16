package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q28107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[n+1];

        for(int i=1; i<=n; i++) arr[i] = new ArrayList<Integer>();

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            for(int j=0; j<k; j++){
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        st = new StringTokenizer(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            q.offer(Integer.parseInt(st.nextToken()));
        }

        int[] customers = new int[n+1];

        while(!q.isEmpty()){
            int s = q.poll();

            for(int i=1; i<=n; i++){
                if(arr[i].contains(s)){
                    customers[i]++;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) sb.append(customers[i] + " ");

        System.out.println(sb);
    }
}
