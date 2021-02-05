import java.util.*;

public class SumOfThreeValues {
    //https://cses.fi/problemset/task/1641
    static class Elem {
        int position;
        Integer value;

        public Elem (int position, int value) {
            this.position = position;
            this.value = value;
        }
    }
    //tle solution, but same solution in c++ will work
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        List<Elem> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Elem(i, scanner.nextInt()));
        }
        list.sort(new Comparator<Elem>() {
            @Override
            public int compare(Elem o1, Elem o2) {
                return o1.value.compareTo(o2.value);
            }
        });
        for (int i = 0; i < n; i++) {
            int buffSum = list.get(i).value;
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                if (buffSum + list.get(start).value + list.get(end).value == x) {
                    buffSum = list.get(i).position + 1;
                    start = list.get(start).position + 1;
                    end = list.get(end).position + 1;
                    System.out.println(buffSum + " " + start + " " + end);
                    return;
                }
                if (buffSum + list.get(start).value + list.get(end).value < x) {
                    start++;
                }
                else {
                    end--;
                }
            }

        }

        System.out.println("IMPOSSIBLE");
    }
}
