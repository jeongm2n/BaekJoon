import java.io.*;
import java.util.StringTokenizer;

public class Q2420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        long abs = Math.abs(N-M);

        System.out.println(abs);
    }
}
