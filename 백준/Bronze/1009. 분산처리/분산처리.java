import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int num = 1;
            for (int j = 0; j < b; j++) {
                num = (a * num) % 10;
                if (num == 0) {
                    num = 10;
                }
            }
            System.out.println(num);
        }
    }
}

