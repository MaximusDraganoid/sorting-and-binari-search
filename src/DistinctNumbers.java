import java.util.*;

public class DistinctNumbers {
    //https://cses.fi/problemset/task/1621
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //version 1
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = scanner.nextInt();
//        }
//
//        int count = 1   ;
//
//        Arrays.sort(array);
//        for (int i = 0; i < n - 1; i++) {
//            if (array[i] != array[i + 1])
//                count++;
//        }
//
//        System.out.println(count);

        //version 2
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(scanner.nextInt());
        System.out.println(set.size());

    }
}
