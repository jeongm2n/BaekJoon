package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2186 {
    static int N, M, K;
    static char[][] graph;
    static int[][][] visited;
    static char[] word;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int dfs(int x, int y, int idx){
        if(idx==word.length-1) return visited[y][x][idx]=1;
        if(visited[y][x][idx]!=-1) return visited[y][x][idx];

        visited[y][x][idx] = 0;

        for(int k=1; k<=K; k++){
            for(int i=0; i<4; i++){
                int nx = x + dx[i] * k;
                int ny = y + dy[i] * k;

                if(nx>=0 && ny>=0 && nx<M && ny<N){
                    if(graph[ny][nx]==word[idx+1]){
                        visited[y][x][idx] += dfs(nx, ny, idx+1);
                    }
                }
            }
        }

        return visited[y][x][idx];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new char[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++) graph[i][j] = s.charAt(j);
        }

        String s = br.readLine();
        word = new char[s.length()];
        visited = new int[N][M][s.length()];

        for(int i=0; i<s.length(); i++) word[i] = s.charAt(i);

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                Arrays.fill(visited[i][j], -1);
            }
        }

        int result = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]==word[0]) result += dfs(j, i, 0);
            }
        }

        System.out.println(result);
    }
}
