import java.io.*;
import java.util.*;

class CCTV{
    int x, y, type;
    CCTV(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

public class Main {
    static int h, w;
    static int[][] map;
    static int[][] copyMap;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;

    static int[][][] dirs = {
            {}, // 0번 없음
            {{0}, {1}, {2}, {3}}, // 1번
            {{0, 2}, {1, 3}}, // 2번
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번
            {{0, 1, 2, 3}} // 4번
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 및 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        // 0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타내고, 문제에서 설명한 CCTV의 종류이다.

        List<CCTV> cctvs = new ArrayList<>();


        map = new int[h][w];
        copyMap = new int[h][w];
        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                copyMap[i][j] = map[i][j];

                if(map[i][j] >= 1 && map[i][j] <=5){
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map, cctvs);
        System.out.println(min);
    }

    static void watch(int x, int y, int dir, int[][] map) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (0 <= nx && nx < h && 0 <= ny && ny < w) {
            if (map[nx][ny] == 6) break; // 벽
            if (map[nx][ny] == 0) map[nx][ny] = -1; // 감시
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    static void dfs(int depth, int[][] map, List<CCTV> cctvs) {
        if (depth == cctvs.size()) {
            min = Math.min(min, countBlind(map));
            return;
        }

        CCTV cam = cctvs.get(depth);
        int type = cam.type;

        for (int[] dirSet : dirs[type]) {
            int[][] tempMap = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    tempMap[i][j] = map[i][j];
                }
            }

            for (int d : dirSet) {
                watch(cam.x, cam.y, d, tempMap);
            }

            dfs(depth + 1, tempMap, cctvs);
        }
    }

    static int countBlind(int[][] map) {
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }

}