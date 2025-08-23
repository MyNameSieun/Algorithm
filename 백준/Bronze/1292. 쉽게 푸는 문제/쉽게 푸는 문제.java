import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[b+1];
        int num = 1;
        int idx = 1;

        while(idx <= b){

            for(int i=0; i<num; i++) {
                if (idx <= b) arr[idx++] = num;
            }
            num++;
        }

        int sum = 0;
        for(int i=a; i<=b; i++){
            sum += arr[i];
        }
        System.out.println(sum);


    }
}