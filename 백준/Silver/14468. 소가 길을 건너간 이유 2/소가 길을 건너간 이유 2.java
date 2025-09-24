import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[26][2];
        char[] ch = br.readLine().toCharArray();
        int ans = 0;

        for(int i=0;i<ch.length;i++){
            int digit = ch[i]-'A';
            if(arr[digit][0]==0) arr[digit][0]=i+1;
            else arr[digit][1]=i+1;
        }


        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(arr[i][0] < arr[j][0] && arr[j][0] < arr[i][1] && arr[i][1] < arr[j][1]) ++ans;
            }
        }

        System.out.println(ans);


    }
}