import java.util.*;

public class JosephusProblemI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> deleted = new HashSet<>();
        int multiplier = 2;
        int startVal = 2;
        StringBuilder res = new StringBuilder("");

        while (deleted.size() != n) {
            if (startVal > n) {
                startVal = startVal % n;
                if (startVal == 0) {
                    startVal = 1;
                }
                while (deleted.contains(startVal)) {
                    startVal = (startVal + 1) % (n + 1);
                    if (startVal == 0) {
                        startVal = 1;
                    }
                }
                multiplier *= 2;
            }

            deleted.add(startVal);
            res.append(startVal);
            res.append(' ');
            startVal += multiplier;
        }

        System.out.println(res);
    }
}
