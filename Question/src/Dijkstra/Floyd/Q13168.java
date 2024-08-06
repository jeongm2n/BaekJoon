package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13168 {
    static HashMap<String, Integer> map = new HashMap<>();
    static int cost, N;
    static int[][] dist; //내일로 샀을 때
    static int[][] non_dist; //내일로 안샀을 때
    static final int INF = 10000001;

    static int vehicle(String s, int c){
        if(s.equals("ITX-Saemaeul") || s.equals("ITX-Cheongchun") || s.equals("Mugunghwa")) return 0;
        if(s.equals("S-Train") || s.equals("V-Train")) return 1;
        return 2;
    }

    static void floyd(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]) dist[i][j] = dist[i][k] + dist[k][j];
                    if(non_dist[i][j] > non_dist[i][k] + non_dist[k][j]) non_dist[i][j] = non_dist[i][k] + non_dist[k][j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            String city = st.nextToken();
            if(map.containsKey(city)){
                i--;
                N--;
                continue;
            }
            map.put(city, i);
        }

        dist = new int[N+1][N+1];
        non_dist = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(dist[i], INF);
            Arrays.fill(non_dist[i], INF);
            dist[i][i] = non_dist[i][i] = 0;
        }

        int M = Integer.parseInt(br.readLine());
        String[] plan = new String[M+1]; 
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++) plan[i] = st.nextToken();

        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            String tran = st.nextToken();
            String a = st.nextToken();
            String b = st.nextToken();
            int m = Integer.parseInt(st.nextToken());

            non_dist[map.get(a)][map.get(b)] = non_dist[map.get(b)][map.get(a)] = Math.min(non_dist[map.get(a)][map.get(b)], m*2);
            dist[map.get(a)][map.get(b)] = dist[map.get(b)][map.get(a)] = Math.min(dist[map.get(a)][map.get(b)], m*vehicle(tran, m));
        }

        floyd();

        int sum = cost*2; 
        int non_sum = 0;

        for(int i=1; i<M; i++){
            int a = map.get(plan[i]);
            int b = map.get(plan[i+1]);

            sum += dist[a][b];
            non_sum += non_dist[a][b];
        }

        System.out.println(non_sum <= sum ? "No" : "Yes");
    }
}
