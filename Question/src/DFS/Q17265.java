package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17265 {
    static int N;
    static char[][] graph;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static boolean operChk(char c){
        if(c=='*' || c=='+' || c=='-') return true;
        return false;
    }

    static int calc(char c, int pre, int cur){
        if(c=='*') return pre*cur;
        else if(c=='+') return pre+cur;
        return pre-cur;
    }

    static void dfs(int x, int y, char c, int result){
        if(y==N-1 && x==N-1){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for(int i=0; i<2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<N && ny<N){
                if(operChk(graph[ny][nx])) dfs(nx, ny, graph[ny][nx], result);
                else{
                    dfs(nx, ny, graph[ny][nx], calc(c, result, graph[ny][nx]-'0'));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                String s = st.nextToken();
                graph[i][j] = s.charAt(0);
            }
        }

        dfs(0,0,graph[0][0],graph[0][0]-'0');
        System.out.println(max + " " + min);
    }
}
