import java.util.Scanner;

public class FactoryMachines {
    //https://cses.fi/problemset/task/1620
    static int[] p;
    static int t;
    static int n;
    //TLE solution
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();//количесво станков
        t = scanner.nextInt();//количество продукции
        p = new int[n];//мощности станков

        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }

        int z = 1000000001;//левая граница
        int k = 0;
        for (int b = z; b >= 1; b /= 2) {
            while (!valid(k + b)) k += b;
        }

        int result = k + 1;
        System.out.println(result);

    }

    static boolean valid(int currentVal) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += currentVal/p[i];
        }
        return sum >= t;
    }

}
