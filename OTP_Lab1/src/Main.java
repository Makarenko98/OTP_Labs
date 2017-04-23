import java.util.Scanner;

/*
c2=1
c3=0
c5=4
c7=5
 */
public class Main {

    public static float func(float n, float m, int c) {
        float result = 0;
        for (float i = 0; i < n; i++)
            if (i != c)
                for (float j = 0; j < m; j++)
                    result += (i - j) / (i - c);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int c = 0;
        float n, m;
        while (true) {
            System.out.print("Enter n: ");
            n = in.nextFloat();
            System.out.print("Enter m: ");
            m = in.nextFloat();
            if (n <= 0 || m <= 0)
                System.out.println("n and m must be greater than zero");
            break;
        }
        System.out.println("Result: " + func(n, m, c));
    }
}
