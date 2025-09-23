import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0; i<n; i++){
            HashSet<Character> set = new HashSet<>();

            String str = br.readLine();
            if(solve(str, set)) ans ++;
        }
        System.out.println(ans);

    }

    static boolean solve(String str, HashSet<Character> set) {
        char prev = ' ';
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(prev == ch) continue;
            if(set.contains(ch)) return false;
            set.add(ch);
            prev = ch;
        }

        return true;
    }
}