import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr = new int[19][19];
    // →, ↓, ↘, ↗
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (arr[i][j] == 0) continue;
                if (solve(i, j)) {
                    System.out.println(arr[i][j]);
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
        System.out.println(0);
    }

    static boolean solve(int x, int y) {
        int color = arr[x][y];

        for (int d = 0; d < 4; d++) {
            int px = x - dx[d];
            int py = y - dy[d];
            if (isValid(px, py) && arr[px][py] == color) continue;

            int count = 1;
            int nx = x + dx[d];
            int ny = y + dy[d];

            while (isValid(nx, ny) && arr[nx][ny] == color) {
                count++;
                nx += dx[d];
                ny += dy[d];
            }

            if (count == 5) {
                int ex = nx;
                int ey = ny;
                if (!isValid(ex, ey) || arr[ex][ey] != color) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isValid(int x, int y) {
        return 0 <= x && x < 19 && 0 <= y && y < 19;
    }
}