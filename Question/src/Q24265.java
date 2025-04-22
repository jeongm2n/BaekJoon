import java.io.*;

public class Q24265 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        
        System.out.println(n*(n-1)/2 + "\n" + 2);
    }
}
