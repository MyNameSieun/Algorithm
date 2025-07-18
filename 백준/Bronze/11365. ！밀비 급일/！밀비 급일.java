import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true){
            String str = br.readLine();
            if(str.equals("END")){
                break;
            }

            StringBuilder sb = new StringBuilder();

            sb.append(str).reverse();

            System.out.println(sb);
        }
    }
}
