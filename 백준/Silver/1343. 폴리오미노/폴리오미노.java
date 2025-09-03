import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch == 'X'){
                if(s.length() - i >= 4 && s.substring(i, i+4).equals("XXXX")){
                    sb.append("AAAA");
                    i+=4;
                } else if(s.length() - i >= 2 && s.substring(i, i+2).equals("XX")){
                    sb.append("BB");
                    i+=2;
                } else{
                    System.out.println(-1);
                    return;
                }

            }else{
                sb.append(".");
                i++;
            }
        }


        System.out.println(sb);
    }
}