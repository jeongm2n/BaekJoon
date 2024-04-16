import java.util.*;

public class Q1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alp = new int[26];

        String s = sc.nextLine().toUpperCase();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int idx = c-65;
            alp[idx]+=1;
        }

        int max = -1;
        char ch = ' ';
        for(int i=0; i<26; i++){
            if (alp[i] > max) {
                max = alp[i];
                ch = (char) (i + 65);
            }
            else if (alp[i] == max) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }
}
