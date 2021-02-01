import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Apartments {
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
                catch (IOException  e)
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
    //https://cses.fi/problemset/task/1084
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FastReader reader = new FastReader();
        int n = reader.nextInt();//число поетителей
        int m = reader.nextInt();//число комнат
        int k = reader.nextInt();//допустимое отклонение

//        List<Integer> apl = new ArrayList<>(n);
//        List<Integer> app = new ArrayList<>(m);

        PriorityQueue<Integer> apl = new PriorityQueue<>();
        PriorityQueue<Integer> app = new PriorityQueue<>();

        //записываем пожелаиня претендентов на квартиры
        for (int i = 0; i < n; i++) {
            apl.add(reader.nextInt());
        }
        //записываем действиетльные размеры квратир
        for (int i = 0; i < m; i++) {
            app.add(reader.nextInt());
        }
//        //упорядочим список желаемых размеров квартир
//        apl.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        //упорядочим квартиры по размерам
//        app.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });


        int resultCount = 0, aplIndex = 0, appIndex = 0;
        while(!app.isEmpty() && !apl.isEmpty()) {
            if (app.peek() >= apl.peek() - k && app.peek() <= apl.peek() + k) {
                app.remove();
                apl.remove();
                resultCount++;
            }
            else {
                if (app.peek() < apl.peek()) {
                    app.remove();
                }
                else {
                    apl.remove();
                }
            }
        }

        System.out.println(resultCount);
    }



}
