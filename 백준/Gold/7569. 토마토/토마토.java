import java.io.*;
import java.util.*;

public class Main {
    static int[][][] arr;

    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};

    static int col, row, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][row][col];
        Deque<int[]> dq = new ArrayDeque<>();

        for(int z=0; z<h; z++){
            for(int i=0; i<row; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<col; j++){
                    arr[z][i][j] = Integer.parseInt(st.nextToken());
                    if(arr[z][i][j] == 1){
                        dq.offer(new int[]{z, i, j});
                    }
                }
            }
        }

        bfs(dq);

        int ans = 0;
        for(int z=0; z<h; z++){
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    if(arr[z][i][j] == -1) continue;

                    if(arr[z][i][j] == 0){
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, arr[z][i][j] - 1);
                }
            }
        }
        System.out.println(ans);
    }

    static void bfs(Deque<int[]> dq){
        // 1. 바로 탐색
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int cz = cur[0], cx = cur[1], cy = cur[2];

            // 2. 6방향, nz, nx, ny 범위
            for(int d=0; d<6; d++){
                int nz = cz + dz[d];
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nz < 0 || nz >= h || nx < 0 || nx >= row || ny < 0 || ny >= col) continue;

                // 3. 미방문 && 이동칸
                if(arr[nz][nx][ny] == 0){
                    arr[nz][nx][ny] = arr[cz][cx][cy] + 1;
                    dq.offer(new int[]{nz, nx, ny});
                }
            }
        }
    }
}