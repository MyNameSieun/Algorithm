import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] arr;
    static char[][] ans;

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new char[n][n];
        ans = new char[n][n];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], '0');
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] != '.'){
                    solve(i, j);
                }
            }
        }

        // 출력
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }

    static void solve(int x, int y) {
        ans[x][y] = '*';
        int mineCount = arr[x][y] - '0';

        for(int d = 0; d<8; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(ans[nx][ny] == '*') continue;

            int sum = (ans[nx][ny] - '0') + mineCount;

            if(sum > 9) ans[nx][ny] = 'M';
            else ans[nx][ny] = (char)('0' + sum);
        }

    }
}