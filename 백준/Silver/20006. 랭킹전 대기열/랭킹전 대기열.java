import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원

        // 정보 저장
        List<User> userList = new ArrayList<>();
        for(int i=0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()); // 레벨
            String n = st.nextToken(); // 닉네임

            userList.add(new User(l, n));
        }

        List<Room> rooms = new ArrayList<>();

        // solve
        for(User user:userList) {
            boolean joined = false;

            // 기존 방 탐색 (레벨 범위, 정원 미만)
            for (Room room : rooms) {
                if (room.users.size() < m &&
                        user.level >= room.level - 10 &&
                        user.level <= room.level + 10) {
                    room.users.add(user);
                    joined = true;
                    break;
                }
            }

            // 못 들어가면 새 방 생성
            if (!joined) {
                Room newRoom = new Room(user.level);
                newRoom.users.add(user);
                rooms.add(newRoom);
            }
        }
        
        // 방 생성 순서대로 출력
        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if (room.users.size() == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            room.users.sort((a, b) -> a.name.compareTo(b.name));
            for (User u : room.users) {
                sb.append(u.level).append(" ").append(u.name).append("\n");
            }
        }
        System.out.print(sb);
    }


    public static class User {
        int level;
        String name;

        public User(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    public static class Room {
        int level;
        ArrayList<User> users = new ArrayList<>();
        Room(int level) {
            this.level = level;
        }
    }
}