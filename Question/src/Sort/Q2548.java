package Sort;

import java.io.*;
import java.util.*;

public class Q2548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        if(N==1){
            System.out.println(arr[0]);
            return;
        }
        System.out.println(N%2==0 ? arr[N/2-1] : arr[N/2]);
    }
}
