// 1:20
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            arr.add(i);
        }

        while(arr.size() >= 2) {
            for(int i = 0; i < arr.size(); i++) {
                arr.remove(i);
            }
        }

        System.out.println(arr.get(0));

    }
}

