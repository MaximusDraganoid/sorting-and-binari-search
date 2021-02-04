import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RoomAllocation {

    static class Pair {
        int index;
        int departureDay;
        Integer arrivalDay;

        public Pair(int index, int arrivalDay, int departureDay) {
            this.arrivalDay = arrivalDay;
            this.departureDay = departureDay;
            this.index = index;
        }
    }
    //TLE solution
    /*
    идея - как в задаче с башнями (жадынй алгоритм: мы будем размещать посетителя в комнате, в которой разница между днем отъезда
    старого жителя и днем приезда нового минимальна) : сначала мы сортируем всех клиентов по дате приезда,
    а затем заселяем их в комнаты, в которые возможно выполнить заселение: комната сначала выбиралась линейно, теперь - бинарно.
    Как только мы отсортируем посетителей по дате приезда, мы получим порядок посетителей по их приезду в отель и
    после этого их легко обрабатывать.
     */

    /*
    Интересное решение здесь https://usaco.guide/solutions/cses-1164?lang=cpp
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Pair> input = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            input.add(new Pair(i, scanner.nextInt(), scanner.nextInt()));
        }

        int[] outputOrder = new int[n];
        input.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.arrivalDay.compareTo(o2.arrivalDay);
            }
        });

        List<Integer> rooms = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int b = rooms.size()/2; b >= 1; b /= 2) {
                while (k + b < rooms.size() && rooms.get(k + b) < input.get(i).arrivalDay) k += b;
            }
            int roomsNum = k + 1;
            if (k == rooms.size() || rooms.get(k) >= input.get(i).arrivalDay) {
                rooms.add(input.get(i).departureDay);
                roomsNum = rooms.size();
            }
            else {
                rooms.set(k, input.get(i).departureDay);
            }
            outputOrder[input.get(i).index] = roomsNum;
        }

        System.out.println(rooms.size());
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            result.append(outputOrder[i]);
            result.append(' ');
        }
        System.out.println(result);

    }
}
