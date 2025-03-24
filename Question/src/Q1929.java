import java.io.*;
import java.util.*;

public class Q1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] flags = new boolean[N+1];

        flags[0] = flags[1] = true;

        for(int i = 2; i <= Math.sqrt(N); i++) {
			if(flags[i]) continue;
			for(int j = i * i; j <= N; j += i) {
				flags[j] = true;
			}
		}

        for(int i=M; i<N; i++){
            if(!flags[i]) System.out.println(i);
        }
    }
}
