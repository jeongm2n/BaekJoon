package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1987 {
    static char[][] graph;
    static boolean[] alpha = new boolean[26];

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int r;
    static int c;

    static int result = 0;

    static void dfs(int x, int y, int cnt){
        if(alpha[graph[y][x]-'A']){
            result = Math.max(result, cnt);
            return;
        }

        alpha[graph[y][x]-'A'] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<c && ny>=0 && ny<r){
                dfs(0,0,cnt+1);
            }
        }

        alpha[graph[y][x]-'A'] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];

        for(int i=0; i<r; i++){
            graph[i] = (br.readLine()).toCharArray();
        }

        dfs(0,0,0);

        System.out.println(result);
    }   
}
