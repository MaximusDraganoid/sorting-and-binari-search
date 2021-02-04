import java.util.Scanner;

public class NestedRangesCheck {
    //https://cses.fi/problemset/task/2168
    public static void main(String[] args) {
        //TLE, need to find optimal solve
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            int resVal = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (a[i] <= a[j] && b[i] >= b[j]) {
                    resVal = 1;
                    break;
                }
            }
            res.append(resVal);
            res.append(' ');
        }

        res.append('\n');
        for (int i = 0; i < n; i++) {
            int resVal = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (a[i] >= a[j] && b[i] <= b[j]) {
                    resVal = 1;
                    break;
                }
            }
            res.append(resVal);
            res.append(' ');
        }

        System.out.println(res);
    }
}
