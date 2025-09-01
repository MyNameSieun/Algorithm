import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][4];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken(); // name
            arr[i][1] = st.nextToken(); // d
            arr[i][2] = st.nextToken(); // m
            arr[i][3] = st.nextToken(); // y
        }

        Arrays.sort(arr, (a, b)->{
            if(a[3].equals(b[3])) return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
            else if(a[2].equals(b[2])) return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            else return Integer.parseInt(a[3]) - Integer.parseInt(b[3]);

        });

        System.out.println(arr[arr.length-1][0]);
        System.out.println(arr[0][0]);


    }
}