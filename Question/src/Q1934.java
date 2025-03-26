import java.io.*;
import java.util.StringTokenizer;

public class Q1934 {
    static int getGcd(int num1, int num2){
        if(num1%num2==0) return num2;
        return getGcd(num2, num1%num2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int max = Math.max(a,b);
            int min = Math.min(a,b);
            
            int gcd = getGcd(max, min);
            int lcm = (a*b)/gcd;

            sb.append(lcm + "\n");
        }

        System.out.println(sb);
    }   
}