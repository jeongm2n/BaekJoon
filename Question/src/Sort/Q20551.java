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

        for(int i=0; i<M; i++){
            int a = Integer.parseInt(br.readLine());
            int tmp = -1;
            for(int j=0; j<N; j++){
                if(a==arr[j]){
                    tmp = j;
                    break;
                }
            }
            sb.append(tmp==-1 ? -1 : tmp).append("\n");
        }

        System.out.println(sb);
    }
}
