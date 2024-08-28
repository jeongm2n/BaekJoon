package Sort.Bubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q23969 {
    static String result = "-1";
    static int K, A;

    static void bubble_sort(int[] arr){
        int cnt = 0;
        for(int last=A; last>=2; last--){
            for(int i=0; i<last-1; i++){
                if(arr[i]>arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    cnt++;
                    if(cnt==K){
                        result = arr[0] + " ";
                        for(int j=1; j<A; j++) result += arr[j] + " ";
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[A];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++) arr[i] = Integer.parseInt(st.nextToken());

        bubble_sort(arr);

        System.out.println(result);
    }
}
