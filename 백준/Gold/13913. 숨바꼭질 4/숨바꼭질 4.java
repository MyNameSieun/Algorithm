import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] dist;
    static int[] v;
    static int s, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        arr = new int[200_001];
        List<Integer> list = new ArrayList<>();

        int ans = bfs();
        System.out.println(ans);

        list.add(e);
        int idx = e;
        while(idx != s){
            list.add(dist[idx]);
            idx = dist[idx];
        }

        for(int i= list.size()-1; i>=0; i--){
            System.out.print(list.get(i) + " ");
        }
    }

    static int bfs(){
        // 1. 초기화
        Deque<Integer> dq = new ArrayDeque<>();
        v = new int[200_001];
        dist = new int[200_001];

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

            // 3-2. 3방향, 범위내, 미방문
            int[] next = {cur - 1 , cur + 1, cur * 2};
            for(int nx : next){
                if(nx >= 0 && nx<=200_000 && v[nx] == 0){
                    dq.offer(nx);
                    v[nx] = v[cur] + 1;
                    dist[nx] = cur;
                }
            }
        }
        return 0;
    }
}

