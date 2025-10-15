import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = -1;
        int maxIdx = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }

        System.out.println(max);
        System.out.println(maxIdx + 1);
    }
}