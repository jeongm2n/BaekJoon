package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2957 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = 0;

        int[] dep = new int[n+2];
        dep[0] = dep[n+1] = -1;

        TreeSet<Integer> tree = new TreeSet<>();

        tree.add(0);
        tree.add(n+1);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            Integer v = Integer.parseInt(br.readLine());
            dep[v] = Math.max(dep[tree.lower(v)],dep[tree.higher(v)])+1;
            tree.add(v);
            result += dep[v];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
