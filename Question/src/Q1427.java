import java.util.*;

public class Q1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            arr.add(s.charAt(i)-'0');
        }

        Collections.sort(arr,Collections.reverseOrder());
        for(int i : arr){
            System.out.print(i);
        }
    }
}
