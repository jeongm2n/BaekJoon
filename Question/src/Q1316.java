import java.util.Scanner;

public class Q1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int cnt = n;
        for(int i=0; i<n; i++){
            String s = sc.nextLine();
            int before = 0;
            boolean[] arr = new boolean[26];

            for (int j = 0; j < s.length(); j++) {
                int now = s.charAt(j); //문자열에서 j번째 문자를 now로 초기화
                if (before != now) {
                    if (!arr[now - 97]) {
                        arr[now - 97] = true;
                        before = now;
                    } else {
                        cnt--;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
