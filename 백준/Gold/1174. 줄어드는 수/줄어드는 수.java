import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) dfs(1, i);

        Collections.sort(list);

        if (n > list.size()) System.out.println(-1);
        else System.out.println(list.get(n - 1));

    }

    static void dfs(int depth, long num) {
        list.add(num);

        if (depth >= 10) return;
        long lastDigit = num % 10;

        for (int i = 0; i < lastDigit; i++) {
            dfs(depth + 1, num * 10 + i);
        }
    }
}