package BFS;

import java.io.*;
import java.util.*;

public class Q23747 {
    static char graph[][];
	static boolean visited[][];
	static int dx[]= {0,0,-1,1};
	static int dy[]= {-1,1,0,0};
	static int r,c;

    static void bfs(int hr, int hc) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {hr, hc});
		visited[hr][hc] = true;
		
		while(!q.isEmpty()) {
			int data[] = q.poll();

			for(int i=0; i<4; i++) {
				int nx = data[0]+dx[i];
				int ny = data[1]+dy[i];
                
				if(nx>=0 && nx<c && ny>=0 && ny<r && !visited[ny][nx]) {
					if(graph[data[0]][data[1]] == graph[ny][nx]) {
						visited[ny][nx]=true;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
		
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		graph = new char[r][c];
		visited = new boolean[r][c];

		for(int i=0; i<r; i++) {
			String str=br.readLine();
			for(int j=0; j<c; j++) {
				graph[i][j]=str.charAt(j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int hr = Integer.parseInt(st.nextToken())-1;
		int hc = Integer.parseInt(st.nextToken())-1;
		
		String str = br.readLine();

		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='W') {
				bfs(hr, hc);
			}else if(str.charAt(i)=='U') {
				hr-=1;
			}else if(str.charAt(i)=='D') {
				hr+=1;
			}else if(str.charAt(i)=='L') {
				hc-=1;
			}else if(str.charAt(i)=='R') {
				hc+=1;
			}
		}
		
		visited[hr][hc] = true;

		for(int i=0; i<4; i++) {
			int nx = hc+dx[i];
			int ny = hr+dy[i];
			if(nx>=0 && nx<c && ny>=0 && ny<r && !visited[ny][nx]) {
				visited[ny][nx] = true;
			}
		}
		
        StringBuilder sb = new StringBuilder();

		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(visited[i][j]) {
					sb.append(".");
				}else {
					sb.append("#");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
    }
}
