import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] fruits = new int[n];

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[10];
        int kind = 0;
        int left = 0;
        int maxLan = 0;
        for(int right = 0; right<n; right++) {
            if(count[fruits[right]] == 0) kind++;
            count[fruits[right]]++;

            // 종류가 2개 될 떄까지 과일 앞에서 제거
            while(kind > 2){
                count[fruits[left]]--;
                if(count[fruits[left]] == 0) kind--;
                left++;
            }

            // 최대 길이 찾기
            maxLan = Math.max(maxLan, right-left + 1);
        }
        System.out.println(maxLan);

    }
}