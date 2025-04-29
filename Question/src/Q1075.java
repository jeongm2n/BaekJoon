import java.io.*;

public class Q1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        N /= 100;
        N *= 100;

        int F = Integer.parseInt(br.readLine());
        int answer = 0;

        while (N % F != 0) {
            N++;
            answer++;
        }

        if (answer < 10) {
            System.out.print("0" + answer);
        } else {
            System.out.print(answer);
        }
    }
}
