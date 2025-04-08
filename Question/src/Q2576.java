
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0; i<7; i++){
            int n = Integer.parseInt(br.readLine());
            
            if(n%2==0) continue;
            
            sum += n;
            min = Math.min(min, n);
        }

        if(sum==0) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
