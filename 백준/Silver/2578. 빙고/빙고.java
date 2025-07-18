import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[5][5];


        // 보드판
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자
        int callCnt = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int x = Integer.parseInt(st.nextToken());
                markChange(x);
                callCnt++;

                if (checkBingo() >= 3) {
                    System.out.println(callCnt);
                    return;
                }
            }
        }
        System.out.println(callCnt);

    }

    // x를 0으로 바꾸기
    static void markChange(int x){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++) {
                if (board[i][j] == x) {
                    board[i][j] = 0;
                    return;
                }
            }
        }
    }


    static int checkBingo(){
        int bingo = 0;

        // 가로
        for(int i=0; i<5; i++){
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 0) cnt++;
            }
            if (cnt == 5) bingo++;
        }


        // 세로
        for(int i=0; i<5; i++){
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (board[j][i] == 0) cnt++;
            }
            if (cnt == 5) bingo++;
        }

        // 대각선 ↘
        int cnt1 = 0;
        for(int i=0; i<5; i++){
            if (board[i][i] == 0) cnt1++;
        }
        if(cnt1 == 5) bingo++;


        // 대각선 ↙
        int cnt2 = 0;
        for(int i=0; i<5; i++){
            if (board[4-i][i] == 0) cnt2++;
        }
        if(cnt2 == 5) bingo++;


        return bingo;
    }
}