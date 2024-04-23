import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2447 {
    static String[][] arr;
    public static void recursive(int x, int y, int n){
        if(n==1){
            arr[x][y] = "*";
            return;
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(!(i==1 && j==1))
                recursive(x+i*(n/3), y+j*(n/3), n/3);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new String[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(arr[i]," ");
        }

        recursive(0,0,n);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) sb.append(arr[i][j]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
