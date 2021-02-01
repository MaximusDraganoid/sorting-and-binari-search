import java.util.Scanner;

public class MaximumSubarraySum {
    //https://cses.fi/problemset/task/1643
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        //идея - в текущей позиции хранить максимальную сумму подмассива, заканчивающегося в этой позиции
        long[] arrWithSum = new long[n];
        for (int i = 0; i < n; i++) {
            arrWithSum[i] = Integer.MIN_VALUE;
        }

        arrWithSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            arrWithSum[i] = Math.max(arr[i], arr[i] + arrWithSum[i - 1]);
        }

        long maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arrWithSum[i] > maxSum)
                maxSum = arrWithSum[i];
        }
        System.out.println(maxSum);

    }
}
