import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SumOfTwoValues {
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
    static class Elem {
        int position;
        Integer value;

        public Elem (int position, int value) {
            this.position = position;
            this.value = value;
        }
    }
    //https://cses.fi/problemset/task/1640
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int x = reader.nextInt();

        List<Elem> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Elem(i, reader.nextInt()));
        }
        list.sort(new Comparator<Elem>() {
            @Override
            public int compare(Elem o1, Elem o2) {
                return o1.value.compareTo(o2.value);
            }
        });

        int start = 0, end = list.size() - 1;
        while (start < end) {
            if (list.get(start).value + list.get(end).value == x) {
                start = list.get(start).position + 1;
                end = list.get(end).position + 1;
                System.out.println(start + " " + end);
                return;
            }
            if (list.get(start).value + list.get(end).value < x) {
                start++;
            }
            else {
                end--;
            }

        }

        System.out.println("IMPOSSIBLE");

    }
}
