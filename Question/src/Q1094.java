import java.io.*;

public class Q1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int answer = 64;
        int cnt = 0;

        while (X>0) { 
            if(answer > X) answer /= 2;
            else{
                X -= answer;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
