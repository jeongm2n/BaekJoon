package Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q12764 {
    static class Person{
        int start;
        int end;
        public Person(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Person> pq = new PriorityQueue<>((o1,o2)->{return o1.start - o2.start;});
        
        int[] nums = new int[100001];
        int[] result = new int[100001];
        int com = 0;
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.offer(new Person(s,e));
        }

        while(!pq.isEmpty()){
            Person p = pq.poll();
            for(int i=1; i<=nums.length; i++){
                if(nums[i]<=p.start){
                    nums[i] = p.end;
                    if(result[i]==0) com++;
                    result[i]++;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(com).append("\n");
        for(int i=1; i<=com; i++){
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
