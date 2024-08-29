package Sort.Selection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q23881 {
    static int[] arr;
    static int N, K;
    static String result = "-1";

    static void selection_sort(){
        int cnt = 0;
        for(int left=0; left<N-1; left++){
            int min = left;
            for(int i=left+1; i<N; i++){
                if(arr[i]<arr[min]) min = i;
            }
            if(left!=min){
                int tmp = arr[left];
                arr[left] = arr[min];
                arr[min] = tmp;
                cnt++;
                if(cnt==K){
                    result = arr[left] + " " + arr[min];
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
