import java.io.*;
import java.util.*;

public class Q2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;

        for(int i=0; i<5; i++){
            int n = Integer.parseInt(st.nextToken());
            sum += Math.pow(n, 2);
        }

        System.out.println(sum%10);
    }
}
