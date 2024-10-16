package Sort;

import java.io.*;
import java.util.*;

public class Q20551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<N; i++) if(!hm.containsKey(arr[i])) hm.put(arr[i], i);

        for(int i=0; i<M; i++){
            int a = Integer.parseInt(br.readLine());
            int tmp = -1;
            if(hm.containsKey(a)) tmp = hm.get(a);
            sb.append(tmp==-1 ? -1 : tmp).append("\n");
        }

        System.out.println(sb);
    }
}
