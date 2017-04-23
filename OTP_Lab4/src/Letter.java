/**
 * Created by Makarenko on 23.04.2017.
 */
public class Letter {
    private char letter;

    public Letter(char letter) {
        setLetter(letter);
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        if (isLetter(letter))
            this.letter = letter;
    }

    public static boolean isLetter(char letter) {
        return !(letter == ' ' || letter == ',' || letter == ':' || letter == ';'
                || letter == '-' || letter == '.' || letter == '!' || letter == '?');
    }

    @Override
    public String toString() {
        return String.valueOf(letter);
    }
}
