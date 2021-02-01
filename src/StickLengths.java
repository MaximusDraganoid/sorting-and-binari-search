import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StickLengths {
    //https://cses.fi/problemset/task/1074
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
        идея: Для того, чтобы сумма разностей была минимальна, необходимо вычесть из каждой
        величины усредненное значение.
        Идея в том, чтобы использовать усредненное значение массива.
        Т.е. нам, нужно остортировать его и взять то, которое лежит в середине (А НЕ СУММУ первого и последнего элеметнов,
        деленую на 2). Оно и будет усредненным.
        Затем от каждой величины вычитать усредненное значение и складывать в финальной ценой.
         */
        FastReader reader = new FastReader();
        int n = reader.nextInt();

        //массив с длинами
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = reader.nextInt();
        }

        Arrays.sort(input);
        int average = input[(n - 1)/2];

        long resultCost = 0;
        long prev = 0;
        for (int i = 0; i < n; i++) {
            prev = resultCost;
            resultCost += Math.abs(input[i] - average);
            if (prev > resultCost)
                System.out.println("FUCK");
        }

        System.out.println(resultCost);
    }
}
