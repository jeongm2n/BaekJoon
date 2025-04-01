
import java.io.*;
import java.util.Arrays;

public class Q5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] burgers = new int[3];
        int[] drinks = new int[2];

        for(int i=0; i<3; i++){
            int N = Integer.parseInt(br.readLine());
            burgers[i] = N;
        }
        for(int i=0; i<2; i++){
            int N = Integer.parseInt(br.readLine());
            drinks[i] = N;
        }

        Arrays.sort(burgers);
        Arrays.sort(drinks);

        System.out.println(burgers[0]+drinks[0]-50);
    }   
}
