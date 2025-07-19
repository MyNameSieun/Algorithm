import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();

            if (str.equals("end")) break;

            // 조건 1. 모음 하나를 포함해야함 -> 모음을 포함했는지 체크하는 상태 변수 필요
            // 조건 2. 모음 혹은 자음이 3개 연속으로 오면 안됨
            // -> 3개 연속으로 왔는지 체크하기 위해 cnt 변수, 상태 변수 필요
            // 3. 같은 글자가 연속적으로 오면 안되나, ee와 oo는 허용한다.
            // -> 같은 글자가 연속적으로 왔는지 체크하는 상태 변수 필요

            boolean isVowel = false;
            boolean isSafe = true;
            int vowelCnt = 0;
            int consonantCnt = 0;

            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);

                // 조건 1
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    isVowel = true;
                }

                // 조건 2
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch =='u'){
                    vowelCnt ++;
                    consonantCnt = 0;
                }else{
                    consonantCnt ++;
                    vowelCnt = 0;
                }
                if(vowelCnt >= 3 || consonantCnt >= 3){
                    isSafe = false;
                }

                // 조건 3
                if(i>0 && str.charAt(i-1) == str.charAt(i)){
                    if(!(ch == 'e' || ch == 'o')){
                        isSafe = false;
                    }
                }
            }

            // 출력
            if(!isVowel) isSafe = false;

            if(isSafe){
                System.out.println("<" + str + ">" + " is acceptable.");
            }else{
                System.out.println("<" + str + ">" + " is not acceptable.");
            }

        }
    }
}
