import java.util.Scanner;

public class SubarraySumsI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = scanner.nextInt();
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int start = 0, end = 0;
        long currSum = 0;
        long count = 0;

        while (start < n) {
            if (currSum == sum){
                count++;
            }

            if (currSum < sum && end < n) {
                currSum += a[end];
                end++;
            }
            else {
                currSum -= a[start];
                start++;
            }
        }
        System.out.println(count);
    }
}
