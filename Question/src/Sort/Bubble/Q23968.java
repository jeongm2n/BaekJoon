package Sort.Bubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q23968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[A];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++) arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        String result = "-1";
        
        for(int last=A; last>=2; last--){
            for(int i=0; i<last-1; i++){
                if(arr[i]>arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    cnt++;
                    if(cnt==K){
                        result = arr[i] + " " + arr[i+1];
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
