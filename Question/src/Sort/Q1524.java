package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String L = br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int Jmax = 0;
			int Bmax = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int J = Integer.parseInt(st.nextToken());	
				if(Jmax < J) Jmax = J;
			}
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int B = Integer.parseInt(st.nextToken());		
				if(Bmax < B) Bmax = B;
			}

			if(Jmax > Bmax) System.out.println("S");
			else if(Bmax > Jmax) System.out.println("B");
			else System.out.println("S");
		}
    }   
}
