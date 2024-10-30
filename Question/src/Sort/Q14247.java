package Sort;

import java.io.*;
import java.util.*;

public class Q14247 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long sum = 0;
		
		int[][] tree = new int[n][2]; 

        for(int z=0; z<2; z++){
            String[] input = br.readLine().split(" ");
	
            for(int i=0; i<n; i++) {
                tree[i][z] = Integer.parseInt(input[i]);
            }
        }
		
		Arrays.sort(tree, (o1, o2)->{
            return o1[1]-o2[1];
        });
		
		for(int day = 0; day < n; day++) {
			sum += tree[day][0] + tree[day][1]*day;
		}

        System.out.println(sum);
    }
}
