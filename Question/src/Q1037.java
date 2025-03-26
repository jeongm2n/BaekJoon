
import java.io.*;
import java.util.*;

public class Q1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];

        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);
        System.out.println(nums[0]*nums[N-1]);
    }
}
