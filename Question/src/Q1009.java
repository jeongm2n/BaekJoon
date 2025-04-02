import java.io.*;
import java.util.*;

public class Q1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = 1;
            
            for(int i=0; i<b; i++) r = (r*a)%10;

            sb.append(r==0 ? 10 : r).append("\n");
        }
        System.out.println(sb);
    }
}
