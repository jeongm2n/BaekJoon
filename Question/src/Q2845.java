import java.io.*;
import java.util.*;

public class Q2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] arr = new int[5];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<5; i++) arr[i] = Integer.parseInt(st.nextToken());

        int mult = L*P;
        for(int i : arr) System.out.print(i-mult + " ");
    }
}
