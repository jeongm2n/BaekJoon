import java.io.*;

public class Q10886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[2];

        for(int i=0; i<N; i++){
            int a = Integer.parseInt(br.readLine());
            arr[a]++;
        }

        System.out.println(arr[0]>arr[1] ? "Junhee is not cute!" : "Junhee is cute!");
    }
}
