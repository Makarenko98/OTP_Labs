/**
 * Created by Makarenko on 23.04.2017.
 */
public class Mark {
    private char mark;
    private int position;

    public Mark(char mark, int position) {
        setMark(mark);
        setPosition(position);
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char delimeter) {
        if (delimeter == ' ' || delimeter == ',' || delimeter == ':' || delimeter == ';' || delimeter == '-')
            this.mark = delimeter;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if (position >= 0)
            this.position = position;
    }

    public static boolean isMark(char mark) {
        return mark == ',' || mark == ':' || mark == ';' || mark == '-';
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}
