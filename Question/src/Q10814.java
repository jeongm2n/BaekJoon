import java.util.*;

public class Q10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[][] arr = new String[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = sc.next();
            arr[i][1] = sc.next();
        }

        Arrays.sort(arr, (arr_1, arr_2) -> {
            return Integer.parseInt(arr_1[0]) - Integer.parseInt(arr_2[0]);
        });

        for(int i=0; i<n; i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }   
}
