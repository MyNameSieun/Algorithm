import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n+m == 0) break;

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++){
                    int x = Integer.parseInt(st.nextToken());
                    map.put(x, map.getOrDefault(x, 0)+1);
                }
            }

            Set<Integer> set = new HashSet<>(map.values());
            List<Integer> countList = new ArrayList<>(set);
            Collections.sort(countList, Collections.reverseOrder());

            int second = countList.get(1);

            List<Integer> result = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == second) {
                    result.add(entry.getKey());
                }
            }

            Collections.sort(result);
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }


    }
}

