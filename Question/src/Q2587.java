import java.io.*;
import java.util.Arrays;

public class Q2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int[] arr = new int[5];

        for(int i=0; i<5; i++){
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            sum += n;
        }

        Arrays.sort(arr);

        System.out.println(sum/5);
        System.out.println(arr[2]);
    }
}
