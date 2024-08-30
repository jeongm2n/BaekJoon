package Sort;

import java.io.*;
import java.util.*;

public class Q2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());
        ArrayList<Integer> w = new ArrayList<>();
        ArrayList<Integer> h = new ArrayList<>();
        w.add(0);
        h.add(0);
        w.add(W);
        h.add(H);

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            if(c==0) h.add(Integer.parseInt(st.nextToken()));
            if(c==1) w.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(w);
        Collections.sort(h);

        int maxW = Integer.MIN_VALUE;
        for(int i=0; i<w.size()-1; i++){
            int gap = Math.abs(w.get(i)-w.get(i+1));
            maxW = Math.max(gap, maxW);
        }
        int maxH = Integer.MIN_VALUE;
        for(int i=0; i<h.size()-1; i++){
            int gap = Math.abs(h.get(i)-h.get(i+1));
            maxH = Math.max(gap, maxH);
        }

        System.out.println(maxW * maxH);
    }
}
