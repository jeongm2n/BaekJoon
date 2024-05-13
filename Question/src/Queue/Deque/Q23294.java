package Queue.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q23294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sites = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) sites[i] = Integer.parseInt(st.nextToken());

        int cache = 0;
        int cap = 0;

        Deque<Integer> back = new ArrayDeque<>();
        Deque<Integer> front = new ArrayDeque<>();

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();

            switch(com){
                case "B":
                    if(!back.isEmpty()){
                        front.offerFirst(cache);                        
                        cache = back.pollLast();
                    }
                    break;
                case "F":
                    if(!front.isEmpty()){
                        back.offerLast(cache);
                        cache = front.pollFirst();
                    }
                    break;
                case "A":
                    int tmp = Integer.parseInt(st.nextToken());
                    if(cache==0){
                        cache = tmp;
                        cap += sites[tmp];
                        break;
                    }else{
                        while(!front.isEmpty()) cap -= sites[front.poll()];
                        back.offerLast(cache);
                        cache = tmp;
                        cap+=sites[cache];
                        if(!back.isEmpty()){
                            while(cap>c){
                                int a = sites[back.poll()];
                                cap -= a;
                            }
                        }
                    }
                    break;
                case "C":
                    Deque<Integer> temp = new ArrayDeque<>();
                    for(int x : back){
                         if(temp.isEmpty()) temp.add(x);
                         else{
                            if(temp.peekLast()!=x) temp.add(x);
                            else cap -= sites[x];
                         }
                    }
                    back = temp;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cache).append("\n");

        if(back.isEmpty()) sb.append(-1).append("\n");
        else{
            while(!back.isEmpty()) sb.append(back.pollLast() + " ");
            sb.append("\n");
        }

        if(front.isEmpty()) sb.append(-1).append("\n");
        else{
            while(!front.isEmpty()) sb.append(front.pollFirst() + " ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
