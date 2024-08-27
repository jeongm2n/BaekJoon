package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2822 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<int[]> arr = new ArrayList<>();

        for(int i=1; i<=8; i++){
            int N = Integer.parseInt(br.readLine());
            arr.add(new int[] {i, N});
        }

        Collections.sort(arr, (o1,o2)->{
            return o2[1] - o1[1];
        });

        int sum = 0;
        int[] num = new int[5];

        for(int i=0; i<5; i++){
            int[] data = arr.get(i);
            sum += data[1];
            num[i] = data[0];
        }

        Arrays.sort(num);

        System.out.println(sum);
        for(int i : num) System.out.print(i + " ");
    }
}
