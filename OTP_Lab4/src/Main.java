import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Text text; //= new StringBuilder("Gi lol kek cheburek? asd fasd. Arb brch kscs klm?");
        Scanner in = new Scanner(System.in);
        TextAnalyzer ta;
        int length = 0;
        System.out.println("Enter text:");
        text = new Text(new StringBuilder(in.nextLine()));
        while (true) {
            System.out.println("Enter the length of the words:");
            length = in.nextInt();
            if (length > 0)
                break;
            System.out.println("Length must be greater than zero");
        }
        ta = new TextAnalyzer(text);
        ta.FindWords(length);
        System.out.println("Words:");
        ta.printWords();
    }
}
