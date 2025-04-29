import java.io.*;

public class Q24416 {
    static int cnt1=0, cnt2=0, f[];

    static int fib(int N){
        if(N==1 || N==2) {
            cnt1++;
            return 1;
        }
        else return (fib(N-1)+fib(N-2));
    }

    static int fibonacci(int N){
        f[0] = 1;
        f[1] = 1;

        for(int i=2; i<N; i++){
            f[i] = f[i-1] + f[i-2];
            cnt2++;
        }

        return f[N-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        f = new int[N];

        fib(N);
        fibonacci(N);

        System.out.println(cnt1 + " " + cnt2);
    }
}
