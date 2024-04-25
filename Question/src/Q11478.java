import java.util.*;

public class Q11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Set<String> hs = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                hs.add(s.substring(i, j));
            }
        }
        System.out.println(hs.size());
    }
}
