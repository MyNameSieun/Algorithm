import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 출근-추가, 퇴근-제거

        Set<String> set = new HashSet<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if(status.equals("enter")){
                set.add(name);
            }else{
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Comparator.reverseOrder());

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
