import java.io.*;
import java.util.*;

public class Q1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        for(int z=0; z<N; z++){
            int n = Integer.parseInt(st.nextToken());
            boolean flag = false;

            if(n<=1) continue;

            for(int i=2; i<n; i++){
                if(n%i==0) {
                    flag = true;
                    break;
                }
            }
            
            if(!flag) cnt++;
        }

        System.out.println(cnt);
    }
}
