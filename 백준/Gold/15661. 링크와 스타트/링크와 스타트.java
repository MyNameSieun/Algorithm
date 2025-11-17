import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static int[][] S; 
    static int minDiff = Integer.MAX_VALUE; 

    static boolean[] v; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        v = new boolean[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(minDiff);
    }

    static void dfs(int idx) {
        if (idx == N) {
            calculateDifference();
            return;
        }

        v[idx] = true;
        dfs(idx + 1);

        v[idx] = false;
        dfs(idx + 1);
    }

    static void calculateDifference() {
        int startScore = 0;
        int linkScore = 0;
        int startCount = 0;
        
        for (boolean selected : v) {
            if (selected) startCount++;
        }

        if (startCount == 0 || startCount == N) {
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (v[i] && v[j]) {
                    startScore += S[i][j];
                } 
                else if (!v[i] && !v[j]) {
                    linkScore += S[i][j];
                }
            }
        }

        int diff = Math.abs(startScore - linkScore);
        minDiff = Math.min(minDiff, diff);
    }
}