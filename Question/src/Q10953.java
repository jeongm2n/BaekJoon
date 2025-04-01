import java.io.*;

public class Q10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            String str = br.readLine();
            String[] arr = str.split(",");

            int sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
