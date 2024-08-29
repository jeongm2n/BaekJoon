package Sort;

import java.io.*;
import java.util.*;

public class Q5635 {
    static class Student{
        String name;
        int y, m, d;
        public Student(String name, int y, int m, int d){
            this.name = name;
            this.y = y;
            this.m = m;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Student> arr = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Student(name, y, m, d));
        }

        StringBuilder sb = new StringBuilder();


        Collections.sort(arr, (o1,o2)->{
            if(o1.y==o2.y){
                if(o1.m==o2.m) return o2.d-o1.d;
                return o2.m-o1.m;
            }
            return o2.y-o1.y;
        });

        sb.append(arr.get(0).name).append("\n");
        
        Collections.sort(arr, (o1,o2)->{
            if(o1.y==o2.y){
                if(o1.m==o2.m) return o1.d-o2.d;
                return o1.m-o2.m;
            }
            return o1.y-o2.y;
        });

        sb.append(arr.get(0).name).append("\n");
        
        System.out.println(sb);
    }
}
