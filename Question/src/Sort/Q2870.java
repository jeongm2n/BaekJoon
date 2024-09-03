package Sort;

import java.io.*;
import java.util.*;
import java.math.*;

public class Q2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<BigInteger> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            String s = "";
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(c>='a' && c<='z'){
                    if(s!=""){
                        arr.add(new BigInteger(s));
                        s="";
                    }
                    continue;
                }
                s += c;
            }
            if(s!="") arr.add(new BigInteger(s));
        }

        Collections.sort(arr);

        for(BigInteger i : arr) System.out.println(i);
    }
}
