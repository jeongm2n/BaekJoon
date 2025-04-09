import java.io.*;
import java.util.*;

public class Q9063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] Xs = new int[N];
        int[] Ys = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            Xs[i] = Integer.parseInt(st.nextToken());
            Ys[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Xs);
        Arrays.sort(Ys);

        System.out.println((Xs[N-1]-Xs[0]) * (Ys[N-1]-Ys[0]));
    }
}
