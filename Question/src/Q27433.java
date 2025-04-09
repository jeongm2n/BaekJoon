import java.io.*;

public class Q27433 {
    static long factorial(long n){
        if(n==1) return n;
        return n * factorial(n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
    }
}
