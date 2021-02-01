import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConcertTickets {
    //https://cses.fi/problemset/task/1091
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {
        //не проходит по времени
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();//число билетов
        int m = scanner.nextInt();//число клиентов

        //записываем цену каждого билета
        List<Integer> prices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            prices.add(scanner.nextInt());
        }

        //записываем деньги на билеты покупателей
        List<Integer> cash = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            cash.add(scanner.nextInt());
        }

        //сортируем билеты по ценам
        prices.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });

        StringBuilder resStr = new StringBuilder("");

        for (int i = 0; i < m; i++) {
            int searchedPrice = cash.get(0);
            int x = -1;

            //решение оптимизационной задачи при помощи бинарного поиска. Мы отсортировали
            //массив так, чтобы ддля всех индексов до определенного индекса k решения были недопустимы,
            //после него решения были бы допустими. Мы ищем максимальное недопустимое решение, тогда следующее
            //за ним решение - будет минимальным допустимым, т.е. тем, которые мы ищем
            for (int b = prices.size(); b >= 1; b /= 2) {
                while(x + b < prices.size() && !valid(prices.get(x + b), searchedPrice))
                    x += b;
            }
            x += 1;
            if (x <= prices.size() - 1 && searchedPrice >= prices.get(x)) {
                resStr.append(prices.get(x));
                resStr.append('\n');
                prices.remove(x);
                cash.remove(0);
            }
            else {
                resStr.append(-1);
                resStr.append('\n');
                cash.remove(0);
            }


        }

        System.out.println(resStr);

    }

    static boolean valid(int currentVal, int searchedVal) {
        if (searchedVal >= currentVal)
            return true;
        return false;
    }
}
