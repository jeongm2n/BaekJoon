
import java.io.*;

public class Q9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(N%2==0 ? "CY" : "SK");
    }
}
