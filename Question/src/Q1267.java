import java.io.*;
import java.util.StringTokenizer;

public class Q1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int y=0, m=0;
        for(int i=0; i<N; i++){
            y += (arr[i]/30 + 1) * 10;
            m += (arr[i]/60 + 1) * 15;
        }

        if(y==m) System.out.println("Y M " + y);
        else System.out.println(y<m ? "Y " + y : "M " + m);
    }
}
