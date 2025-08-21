import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] v;
    static int s, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());


        arr = new int[200_001];

        int ans = bfs();
        System.out.println(ans);
    }

    static int bfs(){
        // 1. 초기화
        Deque<Integer> dq = new ArrayDeque<>();
        v = new int[200_001];

        // 2. 초기값
        dq.offer(s);
        v[s] = 1;

        // 3. 탐색
        while(!dq.isEmpty()){
            int cur = dq.poll();
            // 3-1. 종료 조건
            if(cur == e){
                return v[cur] - 1;
            }

            // 3-2. 3방향, 범위내, 미방문, 조건 추가
            int[] next = {cur - 1 , cur + 1, cur * 2};
            for(int nx : next){
                if(nx >= 0 && nx<=200_000 && v[nx] == 0){

                    if(nx == cur * 2 && nx != 0){
                        v[nx] = v[cur];
                        dq.offerFirst(nx);
                    }else{
                        v[nx] = v[cur] + 1;
                        dq.offerLast(nx);
                    }
                }
            }
        }
        return 0;
    }
}

