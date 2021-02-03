import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TrafficLights {
    //https://cses.fi/problemset/task/1163
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
/*
идея решения - в одну структуру (отсортированное множество) данных записываем точки, которые
добавляем, в другую записываем расстояния и динамически меняем
их по мере добавления новых точек в множество (очередь с приоритетом)
 */
    public static void main(String[] args) {
        //TLE solve, but same solve in C++ works
        FastReader reader = new FastReader();
        int x = reader.nextInt();
        int n = reader.nextInt();

        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = reader.nextInt();
        }

        PriorityQueue<Integer> qOfDist = new PriorityQueue<>((t, y) -> Integer.compare(y, t));
        qOfDist.add(x);

        NavigableSet<Integer> qOfPoints = new TreeSet<>();
        qOfPoints.add(0);
        qOfPoints.add(x);
        int coutn = 0;

        for (int i = 0; i < n; i++) {
            //if (positions[i] == 0 || positions[i] == x) continue;
            if (positions[i] != x || positions[i] != 0) {
                qOfPoints.add(positions[i]);
                qOfDist.remove(qOfPoints.higher(positions[i]) - qOfPoints.lower(positions[i]));
                qOfDist.add(positions[i] - qOfPoints.lower(positions[i]));
                qOfDist.add(qOfPoints.higher(positions[i]) - positions[i]);
                System.out.println(qOfDist.peek());
            }


        }
    }
}