package Sort;

import java.io.*;
import java.util.*;

public class Q2535 {
    static class Student{
        int cnum, num, point;
        public Student(int cnum, int num, int point){
            this.cnum = cnum;
            this.num = num;
            this.point = point;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] carr = new int[101];
        ArrayList<Student> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnum = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            arr.add(new Student(cnum, num, point));
        }
        
        Collections.sort(arr,(o1,o2)->{return o2.point-o1.point;});
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for(Student s : arr){
            if(carr[s.cnum]>=2) continue;
            if(cnt==3) break;
            carr[s.cnum]++;
            sb.append(s.cnum + " " + s.num).append("\n");
            cnt++;
        }

        System.out.println(sb);
    }
}
