import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;

public class Playlist {
    //https://cses.fi/problemset/task/1141
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
        FastReader reader = new FastReader();
        int n = reader.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = reader.nextInt();
        }

        Set<Integer> set = new HashSet<>();

        //основная идея: мы проходим входной массив слева направо, и добавляем эоементы в множество.
        //если добавляемый элемент в множестве уже есть, сдвигаемся до повторяющегося элемента,
        //попутно удалаяя добавленные до него элементы в множество, предварительно вычислив новую
        //наибольшую длину

        int maxLenOfSeq = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(array[i])) {
                maxLenOfSeq = Math.max(maxLenOfSeq, set.size());
                while (array[prev] != array[i]){
                    set.remove(array[prev]);
                    prev++;
                }
                set.remove(array[prev]);
                prev++;

            }
            set.add(array[i]);
        }
        maxLenOfSeq = Math.max(maxLenOfSeq, set.size());
        System.out.println(maxLenOfSeq);
    }
}
