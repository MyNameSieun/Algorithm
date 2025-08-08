import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();


        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            if (dir == 0) row.add(val); // 가로(행) 자르기 -> 열로
            else col.add(val); // 세로(열)로 자르기 -> 행으로
        }
        row.add(0);
        row.add(w);
        col.add(0);
        col.add(h);

        Collections.sort(row);
        Collections.sort(col);

        // row max사이즈 구하기

        int maxRow = 0;
        int maxCol = 0;
        for(int i=0; i<row.size()-1; i++){
            maxRow = Math.max(maxRow,  row.get(i+1) - row.get(i));
        }
        for(int i=0; i<col.size()-1; i++){
            maxCol = Math.max(maxCol,  col.get(i+1) - col.get(i));
        }
        System.out.println(maxRow * maxCol);
    }
}