import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();

        // . 을 기준으로 나누고 뒤에 있는 배열을 key로 두기
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split("\\.");
            String name = input[0]; // 이름
            String ext = input[1]; // 확장자(key)

            map.put(ext, map.getOrDefault(ext, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            sb.append(entry.getKey()).append(" ").append(entry.getValue());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
