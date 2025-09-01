import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=1; i<=n; i++) dq.offer(i);


        StringBuilder sb = new StringBuilder();

        sb.append("<");
        while(!dq.isEmpty()){
            for(int i=0; i<k-1; i++){
                dq.offer(dq.poll());
            }
            sb.append(dq.poll());
            if(dq.size() >= 1) sb.append(", ");
        }
        sb.append(">");

        System.out.print(sb);
    }
}