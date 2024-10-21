package Sort;

import java.io.*;
import java.util.*;

public class Q16466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		int cnt = 0;
		for(int i=0; i<n; i++) {
			if (arr[i]!=i+1) {
				System.out.println(i+1);
				cnt++;
				break;
			}
		}
		if (cnt == 0) {
			System.out.println(n+1);
		}
    }
}
