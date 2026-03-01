package BOJ.BOJ20006;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final String START = "Started!";
    static final String WAITING = "Waiting!";

    static class Player implements Comparable<Player> {
        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }

        @Override
        public String toString() {
            return level + " " + nickname;
        }
    }

    static class Room {
        int baseLevel;
        List<Player> players;

        public Room(Player player) {
            this.baseLevel = player.level;
            this.players = new ArrayList<>();
            this.players.add(player);
        }

        public boolean canJoin(Player player, int maxSize) {
            return (baseLevel - 10 <= player.level &&
                    player.level <= baseLevel + 10 &&
                    players.size() < maxSize);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int m = sc.nextInt();

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            Player newPlayer = new Player(sc.nextInt(), sc.next());
            boolean joined = false;

            for (Room room : rooms) {
                if (room.canJoin(newPlayer, m)) {
                    room.players.add(newPlayer);
                    joined = true;
                    break;
                }
            }

            if (!joined) {
                rooms.add(new Room(newPlayer));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Room room : rooms) {

            if (room.players.size() == m) {
                sb.append(START).append("\n");
            } else {
                sb.append(WAITING).append("\n");
            }

            Collections.sort(room.players);

            for (Player player : room.players) {
                sb.append(player).append("\n");
            }
        }

        System.out.print(sb);
    }
}