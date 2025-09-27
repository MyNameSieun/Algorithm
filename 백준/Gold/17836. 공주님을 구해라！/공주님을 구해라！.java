import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][][] v;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        v = new int[n][m][2]; // [x][y][검여부]

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solve
        int ans = bfs(0, 0);

        // output
        System.out.println(ans > t ? "Fail" : ans);
    }

    static int bfs(int x, int y){
        // 1. 초기화
        Deque<Pos> dq = new ArrayDeque<>();

        // 2. 초기값
        dq.offer(new Pos(x, y, 0));
        v[x][y][0] = 1;

        // 3. 탐색
        while(!dq.isEmpty()) {
            Pos cur = dq.poll();

            // 3.1 종료조건
            if (cur.x == n-1 && cur.y == m-1) {
                return v[cur.x][cur.y][cur.sword] - 1;
            }

            // 3.2 4방향, 범위
            for(int d = 0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 검 없는 상태
                if (cur.sword == 0) {
                    if (arr[nx][ny] == 0 && v[nx][ny][0] == 0) {
                        v[nx][ny][0] = v[cur.x][cur.y][0] + 1;
                        dq.offer(new Pos(nx, ny, 0));
                    }
                    if (arr[nx][ny] == 2 && v[nx][ny][1] == 0) { // 검 획득
                        v[nx][ny][1] = v[cur.x][cur.y][0] + 1;
                        dq.offer(new Pos(nx, ny, 1));
                    }
                }

                // 검 있는 상태 -> 벽 통과 가능
                else {
                    if (v[nx][ny][1] == 0) {
                        v[nx][ny][1] = v[cur.x][cur.y][1] + 1;
                        dq.offer(new Pos(nx, ny, 1));
                    }
                }
            }
        }
        return Integer.MAX_VALUE; // 도달 x
    }

    static class Pos{
        int x, y, sword;
        Pos(int x, int y, int sword) {
            this.x = x;
            this.y = y;
            this.sword = sword;
        }
    }
}