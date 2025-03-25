import java.io.*;

public class Q2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] flags = new boolean[N+1];

        flags[0] = flags[1] = true;

        for(int i = 2; i <= Math.sqrt(N); i++) {
			if(flags[i]) continue;
			for(int j = i * i; j <= N; j += i) {
				flags[j] = true;
			}
		}

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int i=M; i<=N; i++){
            if(!flags[i]){
                sum += i;
                min = Math.min(min, i);
            }
        }

        if(sum==0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(min);

    }
}
