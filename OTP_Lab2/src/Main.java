import java.util.Scanner;

public class Main {

    private static void genMatr(char[][] Matrix, char a, char b) {
        for (int i = 0; i < Matrix.length; i++)
            for (int j = 0; j < Matrix[i].length; j++)
                Matrix[i][j] = (char) (Math.random() * (b - a + 1));
    }

    private static void showMatr(char[][] Matrix) {
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[i].length; j++)
                System.out.print((int) Matrix[i][j] + " ");
            System.out.println();
        }
    }

    private static char[][] mult(char[][] A, char[][] B) {
        char[][] C = new char[A.length][B[0].length];
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < B[0].length; j++)
                for(int k = 0; k < B.length; k++)
                    C[i][j] += A[i][k] * B[k][j];
        return C;
    }

    private static double[] average(char[][] Matrix) {
        double[] a = new double[Matrix.length];
        double temp = 0;
        for (int i = 0; i < Matrix.length; i++) {
            temp = 0;
            for (int j = 0; j < Matrix[0].length; j++)
                temp += Matrix[i][j];
            a[i] = temp / Matrix[i].length;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, l;
        System.out.println("A[n][m], B[m][l], C[n][l]");
        while (true) {
            System.out.print("Enter n: ");
            n = in.nextInt();
            System.out.print("Enter m: ");
            m = in.nextInt();
            System.out.print("Enter l: ");
            l = in.nextInt();
            if (m > 0 || n > 0)
                break;
            System.out.println("Incorrect data (n<=0) or (m<=0)");
        }
        char[][] A = new char[n][m];
        char[][] B = new char[m][l];
        genMatr(A, (char) 0, (char) 8);
        genMatr(B, (char) 0, (char) 6);
        System.out.println("A:");
        showMatr(A);
        System.out.println("B:");
        showMatr(B);
        char[][] C = mult(A, B);
        System.out.println("C:");
        showMatr(C);
        double[] a = average(C);
        System.out.println("Average:");
        for (int i = 0; i < a.length; i++)
            System.out.println(i + ". " + a[i]);
    }
}
