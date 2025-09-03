import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r, c, d;
    static int[][] room;
    static int count;

    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 및 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        room = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        cleanRoom();
        System.out.println(count);
    }

    static void cleanRoom(){
        while(true){
            // 현재칸 청소 되어있지 않다면 현재 칸 청소
            if (room[r][c] == 0) {
                room[r][c] = 2;
                count++;
            }

            // 현재 칸 주변 4칸 중 청소되지 않은 칸 있으면
            boolean cleaned = false; //  청소되지 않은 칸 있으면
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 방향으로 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(room[nx][ny] == 0){ // 앞 칸이 청소 안되어있으면
                    r=nx; // 한 칸 전진
                    c=ny;
                    cleaned = true;
                    break;
                }
            }

            if(!cleaned){ // 청소할 칸 없으면
                // 후진 좌표 계산
                int backX = r - dx[d];
                int backY = c - dy[d];

                if(backX < 0 || backX >= n || backY < 0 || backY >= m || room[backX][backY] == 1) {
                    break;
                }else{
                    r = backX;
                    c = backY;
                }
            }


        }
    }
}
