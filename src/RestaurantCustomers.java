import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RestaurantCustomers {
    //https://cses.fi/problemset/task/1619
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

    static class Event implements Comparable{
        Integer time;
        boolean exit;

        public Event(Integer time, boolean exit) {
            this.time = time;
            this.exit = exit;
        }


        @Override
        public int compareTo(Object o) {
            return time.compareTo(((Integer)o));
        }
    }

    public static void main(String[] args) {

        FastReader reader = new FastReader();
        int n = reader.nextInt();

        long[] in = new long[n];
        long[] out = new long[n];

        for (int i = 0; i < n; i++) {
            in[i] = reader.nextLong();
            out[i] = reader.nextLong();
        }

        Arrays.sort(in);
        Arrays.sort(out);

        int maxCount = 0, count = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (in[i] <= out[j]) {
                count++;
                i++;
            }
            else {
                count--;
                j++;
            }

            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.println(maxCount);


        //реализация с введением доп класса
//        List<Event> q = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            q.add(new Event(reader.nextInt(), true));
//            q.add(new Event(reader.nextInt(), false));
//        }
//
//        q.sort(new Comparator<Event>() {
//            @Override
//            public int compare(Event o1, Event o2) {
//                return o1.time.compareTo(o2.time);
//            }
//        });
//
//        int count = 0;
//        int maxCount = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (q.remove(0).exit) {
//                count++;
//            }
//            else
//                count--;
//            if (count > maxCount) {
//                maxCount = count;
//            }
//        }
//
//        System.out.println(maxCount);



    }
}
