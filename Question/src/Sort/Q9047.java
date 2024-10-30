package Sort;

import java.io.*;
import java.util.*;

public class Q9047 {
    static int sort(String s){
        int num = Integer.parseInt(s);
        int result = 0;
        while(num!=6174){
            int[] digits = new int[4];
            for (int i = 0; i < 4; i++) {
                digits[i] = num % 10;
                num /= 10;
            }
            Arrays.sort(digits);

            int min = 0;
            int max = 0;
            for (int i = 0; i < 4; i++) {
                min = min * 10 + digits[i];
                max = max * 10 + digits[3 - i];
            }

            num = max - min;
            result++;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            String s = br.readLine();
            if(s.equals("6174")) sb.append(0).append("\n");
            else{
                sb.append(sort(s)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
