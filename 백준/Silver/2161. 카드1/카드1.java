import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=n; i>=1; i--) dq.offer(i);

        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            sb.append(dq.pollLast()).append(" ");
            if(!dq.isEmpty()){
                dq.offerFirst(dq.pollLast());
            }
        }
        System.out.print(sb);

    }
}