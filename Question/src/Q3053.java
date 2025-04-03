import java.io.*;

public class Q3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double R = Integer.parseInt(br.readLine());
        
        System.out.printf("%.6f", R*R*Math.PI);
        System.out.println();
        System.out.printf("%.6f", R*R*2);
    }
}
