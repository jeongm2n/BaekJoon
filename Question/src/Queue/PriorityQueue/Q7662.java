package Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        TreeMap<Integer,Integer> treeMap;

        StringBuilder sb = new StringBuilder();

        for(int z=0; z<t; z++){
            int k = Integer.parseInt(br.readLine());

            StringTokenizer st;
            treeMap = new TreeMap<>();

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if(command.equals("I")){
                    treeMap.put(n, treeMap.getOrDefault(n, 0)+1);
                }else{
                    if(n==1){
                        if(treeMap.size()==0) continue;
                        int a = treeMap.get(treeMap.lastKey());
                        if(a==1) treeMap.remove(treeMap.lastKey());
                        else treeMap.put(treeMap.lastKey(), a-1);
                    }else {
                        if(treeMap.size()==0) continue;
                        int a = treeMap.get(treeMap.firstKey());
                        if(a==1) treeMap.remove(treeMap.firstKey());
                        else treeMap.put(treeMap.firstKey(),a-1);
                    }
                }
            }

            sb.append(treeMap.size()==0 ? "EMTPY" : treeMap.lastKey() + " " + treeMap.firstKey()).append("\n");
        }
        System.out.println(sb);
    }
}
