import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        // 위쪽
        for(int i = 1; i<=k; i++){
            // 왼쪽
            for(int j=1; j<=i; j++) System.out.print("*");
            for(int j=0; j<k-i; j++) System.out.print(" ");

            // 오른쪽
            for(int j=0; j<k-i; j++) System.out.print(" ");
            for(int j=1; j<=i; j++) System.out.print("*");

            System.out.println();
        }

        // 아래쪽
        for(int i=1; i<k; i++){
            // 왼쪽
            for(int j=0; j<k-i; j++) System.out.print("*");
            for(int j=0; j<i; j++) System.out.print(" ");

            // 오른쪽
            for(int j=1; j<=i; j++) System.out.print(" ");
            for(int j=0; j<k-i; j++) System.out.print("*");

            System.out.println();
        }



    }
}
