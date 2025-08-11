import java.io.*;
import java.util.*;

public class Solution {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 12:35

        int t = 10;
        while(t-->0){
            int tc = Integer.parseInt(br.readLine());
            arr = new int[100][100];

            for(int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int best = Integer.MAX_VALUE;
            int ansCol = 0;
            for(int j=0; j<100; j++){
                if(arr[0][j] == 1){
                    int steps = solved(0, j);
                    if(steps < best){
                        best = steps;
                        ansCol = j;
                    }
                }
            }
            System.out.println("#" + tc + " " + ansCol);
        }
    }

    static int solved(int row, int col){
        int cnt = 0;
        while(row<99){
            // 왼쪽 이동
            if(col>0 && arr[row][col-1] == 1){
                while(col>0 && arr[row][col-1] == 1){
                    col--;
                    cnt ++;
                }
                row++;
            }

            // 오른쪽 이동
            else if(col<99 && arr[row][col+1] == 1){
                while(col<99 && arr[row][col+1] == 1){
                    col++;
                    cnt ++;
                }
                row++;
            }
            // 위로 이동
            else{
                cnt ++;
                row++;
            }
        }

        return cnt;
    }
}

