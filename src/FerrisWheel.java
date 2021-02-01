import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FerrisWheel {
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
    //https://cses.fi/problemset/task/1090
    public static void main(String[] args) {
        //не прошло по времени
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        long maxWeight = scanner.nextLong();
        long[] weightList = new long[n];
        for (int i = 0; i < n; i++) {
            weightList[i] = scanner.nextLong();
        }

        Arrays.sort(weightList);

        int start = 0, end = n - 1, resultCount = 0;
        while (start <= end) {
            if (weightList[end] + weightList[start] <= maxWeight) {
                end--;
                start++;
            }
            else {
                end--;
            }
            resultCount++;
        }

        System.out.println(resultCount);


    }
}
