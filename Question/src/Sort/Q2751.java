package Sort;
import java.util.*;

public class Q2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        for(int i : arr){
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}
