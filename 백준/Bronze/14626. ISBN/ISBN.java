import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력받은 수 중 *의 인덱스 찾기
        // 2. *를 제외하고 가중치* 수 한 것을 sum에 누적
        // 짝수면 가중치 x,  홀수일 때 가중치 3
        // 3. *를 제외한 길이를 순회하며 브루트포스로 sum + x * 가중치 한 것을 result에 저장
        // 4. 만약 result % 10 == 0이면 x리턴 후 break

        String input = br.readLine();
        int blank = 0;
        int sum = 0;

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            if(c == '*'){
                blank = i;
                continue;
            }
            int digit = c - '0';

            if(i%2 == 1) sum += digit * 3;
            else sum += digit;
        }

        for(int x = 0; x <= 9; x++){
            int result = sum + x * (blank % 2 == 0? 1:3);
            if(result % 10 == 0){
                System.out.println(x);
                break;
            }
        }
    }
}