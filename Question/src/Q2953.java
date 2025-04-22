import java.io.*;
import java.util.StringTokenizer;

public class Q2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int idx = 0;

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
    
            for(int j=0; j<4; j++) sum += Integer.parseInt(st.nextToken());
            
            if(max<sum){
                max = sum;
                idx = i+1;
            }
        }

        System.out.println(idx + " " + max);
    }   
}
