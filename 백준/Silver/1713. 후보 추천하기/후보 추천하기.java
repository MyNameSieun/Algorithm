import java.io.*;
import java.util.*;

public class Main {

    static class Student {
        int num;         // 학생 번호
        int recommend;   // 추천 수
        int time;        // 게시된 시간

        Student(int num, int recommend, int time) {
            this.num = num;
            this.recommend = recommend;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int frameSize = Integer.parseInt(br.readLine()); // 사진틀 개수
        int total = Integer.parseInt(br.readLine());     // 총 추천 횟수

        List<Student> frame = new ArrayList<>();
        int time = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < total; i++) {
            int num = Integer.parseInt(st.nextToken()); // 추천받은 학생 번호
            boolean found = false;

            // 이미 게시된 학생이면 추천 수만 증가
            for (Student s : frame) {
                if (s.num == num) {
                    s.recommend++;
                    found = true;
                    break;
                }
            }

            if (found) continue; // 이미 게시된 경우는 생략

            // 게시 안 된 경우
            if (frame.size() >= frameSize) {
                // 정렬: 추천 수 적은 순 -> 오래된 순
                frame.sort((a, b) -> {
                    if (a.recommend == b.recommend) return a.time - b.time;
                    return a.recommend - b.recommend;
                });

                frame.remove(0); // 하나 제거
            }

            // 새로 추가
            frame.add(new Student(num, 1, time++));
        }

        // 최종 학생 번호 정렬 후 출력
        List<Integer> result = new ArrayList<>();
        for (Student s : frame) {
            result.add(s.num);
        }

        Collections.sort(result); // 오름차순 정렬
        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}
