import java.io.*;
import java.util.StringTokenizer;

public class Q2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int person = 0;

        for(int i=0; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int minus = Integer.parseInt(st.nextToken());
            int plus = Integer.parseInt(st.nextToken());

            if(i==0) {
                max = plus;
                person = plus;
                continue;
            }

            person -= minus;
            person += plus;

            max = Math.max(max, person);
        }

        System.out.println(max);
    }
}
