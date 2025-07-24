import java.io.*;
import java.util.*;

public class Main {
    static class Country {
        int id, gold, silver, bronze;

        Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 국가 수
        int k = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가

        List<Country> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Country(id, g, s, b));
        }

        // 금, 은, 동 내림차순
        list.sort((a, b) -> {
            if (a.gold != b.gold) return b.gold - a.gold;
            if (a.silver != b.silver) return b.silver - a.silver;
            return b.bronze - a.bronze;
        });

        int rank = 1;
        int targetRank = 0;

        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                Country prev = list.get(i - 1);
                Country curr = list.get(i);

                if (curr.gold != prev.gold || curr.silver != prev.silver || curr.bronze != prev.bronze) {
                    rank = i + 1;
                }
            }

            if (list.get(i).id == k) {
                targetRank = rank;
                break;
            }
        }

        System.out.println(targetRank);
    }
}
