import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Towers {
    //https://cses.fi/problemset/task/1073
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
        /*
        жадный алгоритм. Мы будем размещать следующий кубик на минимальном из возможных кубиков.
        Первая мысль - обойти весь массив и для каждого элемента линейно искать нужное место. При таком подходе
        хранить всю башню не обязательно и важно хранить лишь верхнее значение.
        Тогда линейный поиск можно заменить на бинарный, т.к. верхние значения будут
        образовывать возрастающую последовательность (в этом несложно убедиться промоделировав сам процесс построения
        башен и порассуждав о том, как выбирается башня
         */
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }

        //TLE - CSES system didn't get it. But you can write same code in C++ and you will solve it:)
        List<Integer> towers = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int a = 0, b = towers.size();
            while (a < b) {
                int k = (a + b)/2;
                if (arr[i] >= towers.get(k)) {
                    a = k + 1;
                }
                else {
                    b = k;
                }
            }

            if (a >= towers.size()) {
                towers.add(arr[i]);
            }
            else {
                towers.set(a, arr[i]);
            }

        }

        System.out.println(towers.size());

    }
}
