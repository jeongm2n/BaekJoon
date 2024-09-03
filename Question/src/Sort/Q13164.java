package Sort;

import java.io.*;
import java.util.*;

public class Q13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        long sum = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<N; i++) list.add(arr[i] - arr[i-1]);    

        Collections.sort(list);

        for(int i=0; i<N-K; i++) sum += list.get(i);

        System.out.println(sum);
    }
}
