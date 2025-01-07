package DFS;

import java.io.*;
import java.util.*;

public class Q26170 {
    static int[][] graph;
    static int bt;
	static boolean visited[][];
	static int dy[] = {-1,1,0,0 };
	static int dx[] = {0,0,-1,1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		graph = new int[5][5];
		visited = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		bt = Integer.MAX_VALUE;
		visited[r][c] = true;
		dfs(r, c, 0, 0);

		if (bt == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(bt);
		}
	}

	private static void dfs(int r, int c, int cnt, int d) {
		if (cnt==3) {
			bt = Math.min(bt, d);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = c + dx[i];
			int ny = r + dy[i];

			if (nx>=0 && nx<5 && ny>=0 && ny<5 && !visited[ny][nx] && graph[ny][nx]!=-1) {
				visited[ny][nx] = true;
				if (graph[ny][nx] == 1) {
					dfs(nx, ny, cnt+1, d+1);
				} else {
					dfs(nx, ny, cnt, d+1);
				}
				visited[ny][nx] = false;
			}
		}
	}
}
