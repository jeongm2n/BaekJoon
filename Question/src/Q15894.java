
import java.io.*;

public class Q15894 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long result = n*2 + n + n;
        System.out.println(result);
    }
}
