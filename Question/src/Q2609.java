
import java.io.*;
import java.util.StringTokenizer;

public class Q2609 {
    static int getGcd(int num1, int num2){
        if(num1%num2==0) return num2;
        return getGcd(num2, num1%num2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int max = Math.max(A,B);
        int min = Math.min(A,B);

        int gcd = getGcd(max, min);
        int lcm = (A*B)/gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}
