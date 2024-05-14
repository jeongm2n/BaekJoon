package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q15809 {
    static int[] army, parent;

    public static int find(int x){
        //각 나라의 부모 나라(동맹을 맺었거나 속국이 된 경우에는 해당 나라가, 동맹도 속국도 아니면 자기 자신이 값) 찾는 함수
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){ //동맹 맺을 때의 메서드
        x = find(x);
        y = find(y);

        //국가 번호가 더 작은 국가가 부모가 되도록 설정 ex) 1 - 2 국가가 동맹을 맺는다면 2의 부모가 1이 되도록
        //부모 국가에 자식 국가의 병력을 합쳐주고 자식 국가의 병력 값은 0으로 변경 ex) 1의 병력 = 10(1의 병력) + 20(2의 병력), 2의 병력 = 0
        if(x>y){
            parent[x]=y;
            army[y] += army[x];
            army[x] = 0;
        }else{
            parent[y]=x;
            army[x] += army[y];
            army[y] = 0;
        }
    }

    public static void war(int x, int y){ //전쟁 할 때의 메서드
        // 각 국가의 부모 국가를 찾아옴
        x = find(x);
        y = find(y);
        
        //부모 국가의 병력을 비교해서 더 작은 쪽이 큰 쪽의 속국이 됨
        //동맹때와 똑같이 병력이 작은 쪽의 부모를 큰 쪽의 부모로 변경
        if(army[x]>army[y]){ 
            parent[y] = x;
            army[x] -= army[y]; //이긴쪽의 병력에서 속국이 된 곳의 병력을 뺌
            army[y] = 0; //속국이 된 곳의 병력은 0으로 변경
        }else if(army[y]>army[x]){
            parent[x] = y;
            army[y] -= army[x];
            army[x] = 0;
        }else{ //두 나라의 병력이 같다면 두 나라 다 멸망해야 함
            //두 나라의 부모 노드와 병력을 모두 0으로 바꿔줌
            parent[x] = 0;
            parent[y] = 0;
            army[x] = 0;
            army[y] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        army = new int[n+1];
        parent = new int[n+1];

        for(int i=1; i<=n; i++){
            army[i] = Integer.parseInt(br.readLine());
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int o = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if(o==1){
                union(p, q);
            }else{
                war(p, q);
            }
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int x : army){
            if(x>0) arr.add(x);
        }

        Collections.sort(arr);

        sb.append(arr.size()).append("\n");
        if(arr.size()!=0){
            for(int x : arr) sb.append(x + " ");
        }

        System.out.println(sb);

    }
}
