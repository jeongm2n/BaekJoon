package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10825 {
    static class Student{
        String name;
        int kor, eng, math;
        public Student(String name, int kor, int eng, int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Student> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           String name = st.nextToken();
           int k = Integer.parseInt(st.nextToken());
           int e = Integer.parseInt(st.nextToken());
           int m = Integer.parseInt(st.nextToken());

           arr.add(new Student(name, k, e, m));
        }

        Collections.sort(arr, (o1,o2)->{
            if(o2.kor==o1.kor){
                if(o1.eng==o2.eng){
                    if(o2.math == o1.math) return o1.name.compareTo(o2.name);
                    return o2.math-o1.math;
                }
                return o1.eng-o2.eng;
            }
            return o2.kor - o1.kor;
        });

        StringBuilder sb = new StringBuilder();
        for(Student s : arr)sb.append(s.name).append("\n");

        System.out.println(sb);
    }
}
