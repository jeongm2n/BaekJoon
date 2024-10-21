package Sort;

import java.io.*;
import java.util.*;

public class Q26215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) q.add(Integer.parseInt(st.nextToken()));

		int result = 0;
		while (!q.isEmpty()) {
			int a = q.poll();

			if (q.isEmpty()) {
				result += a;
				break;
			}
			int b = q.poll();
			result += b;
			q.add(a - b);
		}

		if (result > 1440) System.out.println(-1);
		else System.out.println(result);
    }
}
