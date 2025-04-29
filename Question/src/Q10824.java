import java.io.*;
import java.util.StringTokenizer;

public class Q10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        String C = st.nextToken();
        String D = st.nextToken();

        Long AB = Long.parseLong(A+B);
        Long CD = Long.parseLong(C+D);

        System.out.println(AB + CD);
    }
}
