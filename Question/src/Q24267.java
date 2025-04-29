
import java.io.*;

public class Q24267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        
        long answer = N*(N-1)*(N-2)/6;

        System.out.println(answer);
        System.out.println(3);
    }
}
