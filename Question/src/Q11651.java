import java.util.*;

public class Q11651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (arr_1, arr_2) -> {
            if(arr_1[1]==arr_2[1]){
                return arr_1[0] - arr_2[0];
            }else return arr_1[1] - arr_2[1];
        });

        for(int i=0; i<n; i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
