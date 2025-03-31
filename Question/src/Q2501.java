import java.io.*;
import java.util.*;

public class Q2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        int cnt=0;
        for(int i=1; i<=N; i++) {
            if(N%i==0){
                arr.add(i);
                cnt++;
            }
            if(cnt==K){
                System.out.println(i);
                break;
            }
        }

        if(cnt<K) System.out.println(0);
    }
}
