import java.io.*;

public class Q24266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        System.out.println(N*N*N + "\n" + 3);
    }
}
