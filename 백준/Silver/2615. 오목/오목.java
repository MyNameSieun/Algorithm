import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        arr = new int[19][19];

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solve + print
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] != 0) {
                    if (solve(i, j)) {
                        System.out.println(arr[i][j] == 1 ? 1 : 2);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean solve(int x, int y) {
        int color = arr[x][y];
        for (int d = 0; d < 4; d++) {
            int cnt = 1;
            // 이전 칸 체크
            int bx = x - dx[d];
            int by = y - dy[d];
            if (isValid(bx, by) && arr[bx][by] == color) continue;

            // 다음 칸 체크
            int nx = x + dx[d];
            int ny = y + dy[d];
            while (isValid(nx, ny) && arr[nx][ny] == color) {
                cnt++;
                nx += dx[d];
                ny += dy[d];
            }
            if (cnt == 5) return true;
        }
        return false;
    }

    static boolean isValid(int x, int y) {
        if (x < 0 || x >= 19 || y < 0 || y >= 19) return false;
        return true;
    }
}
