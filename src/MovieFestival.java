import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class MovieFestival {
    //https://cses.fi/problemset/task/1629
    //не прошло по времени. Наверное, если сделать сортировку двух массивов одновременно вручную, то пройдет по времени
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

    static class Event {
        Integer startTime, endTime;

        public Event(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        List<Event> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Event(reader.nextInt(), reader.nextInt()));
        }

        list.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.endTime.compareTo(o2.endTime);
            }
        });

        int count = 1;
        int prevEndTime = list.get(0).endTime;
        for (int i = 1; i < n; i++) {
            if (prevEndTime <= list.get(i).startTime) {
                prevEndTime = list.get(i).endTime;
                count++;
            }
        }

        System.out.println(count);

    }
}
