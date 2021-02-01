import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CollectingNumbers {
    //https://cses.fi/problemset/task/2216
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
    static class Pair {
        int ind;
        Integer value;
        public Pair(int ind, int value) {
            this.ind = ind;
            this.value = value;
        }
    }
    /*
    1 способ решения - перебор
    2 способ решения - отсортировать массив по значениям, а по индексам определять число раундов.
    Идея - за каждый проход слева направо нам нужно искать возрастающие подпоследовательности. Аналогичные
    возрастающие подпоследовательности образуются и в индексах массива хранения данных. Если отсортировать
     по значению, то эти подпоследовательности будут располагаться рядом в возрастающ. порядке и идти с самого
     начала и их будет легко подсчитать.
     */
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        List<Pair> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(i, reader.nextInt()));
        }

        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value.compareTo(o2.value);
            }
        });

        int count = 1;
        int prevInd = list.get(0).ind;
        for (int i = 1; i < n; i++) {
            if (list.get(i).ind < prevInd) {
                count++;
            }
            prevInd = list.get(i).ind;
        }
        System.out.println(count);
    }
}
