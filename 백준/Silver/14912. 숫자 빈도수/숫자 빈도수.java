import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=1; i<=n; i++){
            int num = i;
            while(num > 0) {
                int key = num%10;
                map.put(key, map.getOrDefault(key, 0) + 1);
                num /= 10;
            }
        }

        System.out.println(map.get(d));

    }
}