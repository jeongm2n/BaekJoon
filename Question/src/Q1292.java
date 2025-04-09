import java.io.*;
import java.util.StringTokenizer;
public class Q1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int sum=0;
        int cnt=0;

        for(int i=1; i<=B; i++){
            for(int j=1; j<=i; j++){
                cnt++;

                if(A<=cnt && cnt<=B) sum += i;
            }
        }

        System.out.println(sum);
    }
}
