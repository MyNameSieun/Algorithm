import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 국가의 수
        int k = Integer.parseInt(st.nextToken()); // 등수를 알고싶은 국가

        int[][] country = new int[n][4];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(country, (a, b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]); // 금메달
            else if(a[2] != b[2]) return Integer.compare(a[2], b[2]); // 은메달
            return Integer.compare(a[3], b[3]); // 동메달
        });

        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (country[i][0] == k) {
                System.out.println(rank);
                break;
            }

            if (i > 0 && (
                    country[i][1] != country[i - 1][1] ||
                            country[i][2] != country[i - 1][2] ||
                            country[i][3] != country[i - 1][3])) {
                rank = i + 1;
            }
        }
    }
}
