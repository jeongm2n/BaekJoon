package Queue.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q23300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Deque<Integer> back = new ArrayDeque<>();
        Deque<Integer> front = new ArrayDeque<>();

        int now = 0;

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();

            switch(com){
                case "B":
                    if(!back.isEmpty()){
                        front.offerFirst(now);
                        now = back.pollLast();
                    }
                    break;
                case "F":
                    if(!front.isEmpty()){
                        back.offerLast(now);
                        now = front.poll();
                    }
                    break;
                case "A":
                    if(now==0){
                        now = Integer.parseInt(st.nextToken());
                        break;
                    }
                    else{
                        front.clear();
                        back.offerLast(now);
                        now = Integer.parseInt(st.nextToken());
                    }
                    break;
                case "C":
                    Deque<Integer> temp = new ArrayDeque<>();
                    for(int x : back){
                        if(temp.isEmpty()) temp.offer(x);
                        else{
                            if(temp.peekLast()!=x) temp.offer(x);
                        }
                    }
                    back = temp;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(now).append("\n");
        if(back.isEmpty()) sb.append(-1).append("\n");
        else{
            while(!back.isEmpty()) sb.append(back.pollLast() + " ");
            sb.append("\n");
        }
        if(front.isEmpty()) sb.append(-1).append("\n");
        else{
            while(!front.isEmpty()) sb.append(front.poll() + " ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
