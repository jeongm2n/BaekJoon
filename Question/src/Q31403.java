import java.io.*;

public class Q31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        int C = Integer.parseInt(br.readLine());
        
        String AB = A+B;

        int result1 = Integer.parseInt(A) + Integer.parseInt(B) - C;
        int result2 = Integer.parseInt(AB) - C;

        System.out.println(result1);
        System.out.println(result2);
    }
}
