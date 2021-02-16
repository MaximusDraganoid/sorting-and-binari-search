import java.util.Scanner;
import java.util.Stack;

public class NearestSmallerValues {
    //https://cses.fi/problemset/task/1645
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int []x = new int [n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }

        //идея - использовать стек и строить возрастающие подпоследовательности
        /*
        Ключевое здесь то, что нам нужно найти ближайший элемент, который расположен слева от текущего значения. Для этого, мы
        будем строить стек следующим образом:
        1) мы ищем элемент в теке, который меньше текущего проверяемого элемента до тех пор пока ен найдем или до тех пор, пока стек
        не будет пустым
        2) если стек пустой - значит нет никакого элемента, который меньше текущего
        иначе мы нашли такой элемент и просто добавляем его в стек.
        https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
         */
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && x[stack.peek()] >= x[i]){
                stack.pop();
            }

            if (stack.isEmpty()) {
                result.append('0');
                result.append(' ');
            } else {//(x[stack.peek()] < x[i])
                result.append(stack.peek() + 1);
                result.append(' ');
            }

            stack.add(i);
        }

        System.out.println(result);
    }
}
