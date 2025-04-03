import java.io.*;
import java.util.*;

public class Q2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        int train = 0;

        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            train = train - out + in;
            max = Math.max(max, train);
        }

        System.out.println(max);
    }
}
