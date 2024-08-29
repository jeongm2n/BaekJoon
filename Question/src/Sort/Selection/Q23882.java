package Sort.Selection;

import java.io.*;
import java.util.*;

public class Q23882 {
    static int[] arr;
    static int N, K;
    static String result = "-1";

    static void selection_sort(){
        int cnt = 0;
        for(int last=N-1; last>=1; last--){
            int max = last;
            for(int i=0; i<last; i++){
                if(arr[i]>arr[max]) max = i;
            }
            if(last!=max){
                int tmp = arr[last];
                arr[last] = arr[max];
                arr[max] = tmp;
                cnt++;
                if(cnt==K){
                    result = arr[0] + " ";
                    for(int j=1; j<N; j++) result += arr[j] + " ";
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        selection_sort();

        System.out.println(result);
    }
}
