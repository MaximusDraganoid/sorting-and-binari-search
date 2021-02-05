import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TasksAndDeadlines {
    //https://cses.fi/problemset/task/1630
    static class Pair {
        Integer duration;
        int deadline;

        public Pair(Integer duration, int deadline) {
            this.duration = duration;
            this.deadline = deadline;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Pair> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Pair(scanner.nextInt(), scanner.nextInt()));
        }

        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.duration.compareTo(o2.duration);
            }
        });

        long reward = 0;
        long startTime = 0;
        for (int i = 0; i < n; i++) {
            reward += list.get(i).deadline - list.get(i).duration - startTime;
            startTime += list.get(i).duration;
        }

        System.out.println(reward);
    }

}
