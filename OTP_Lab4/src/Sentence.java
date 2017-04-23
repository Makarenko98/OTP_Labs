import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Makarenko on 23.04.2017.
 */
public class Sentence {
    private Word[] words;
    private int countWords = 0;
    private int countMarks = 0;
    private Mark[] marks;
    private char type;

    public Sentence() {
        words = new Word[5];
        marks = new Mark[5];
    }

    public Sentence(StringBuilder sentence) {
        words = new Word[5];
        marks = new Mark[5];
        parse(sentence);
    }

    public Sentence(Word[] words, Mark[] marks) {
        this.marks = marks;
        this.words = words;
    }

    public boolean addWord(Word word) {
        if(word == null)
            return false;
        if (words.length == this.countWords) {
            Word[] temp = words.clone();
            words = new Word[countWords * 2];
            for (int i = 0; i < countWords; i++)
                words[i] = temp[i];
        }
        words[countWords] = word;
        countWords++;
        return true;
    }

    public boolean addMark(Mark mark) {
        if(mark == null)
            return false;
        if (marks.length == this.countMarks) {
            Mark[] temp = marks.clone();
            marks = new Mark[countMarks * 2];
            for (int i = 0; i < countMarks; i++)
                marks[i] = temp[i];
        }
        marks[countMarks] = mark;
        countMarks++;
        return true;
    }

    public Sentence parse(StringBuilder sentence) {
        type = sentence.charAt(sentence.length() - 1);
        if (type != '.' && type != '!' && type != '?')
            throw new IllegalArgumentException();
        Word word = new Word();
        char symbol;
        for (int i = 0; i < sentence.length(); i++) {
            symbol = sentence.charAt(i);
            if (Letter.isLetter(symbol))
                word.addLetter(new Letter(symbol));
            else {
                if (word.getLength() != 0) {
                    addWord(word);
                    word = new Word();
                }
                if (Mark.isMark(symbol))
                    addMark(new Mark(symbol, countWords - 1));
            }
        }

        return this;
    }


    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    public Mark[] getMarks() {
        return marks;
    }

    public void setMarks(Mark[] marks) {
        this.marks = marks;
    }

    public int getCountWords() {
        return countWords;
    }

    public int getCountMarks() {
        return countMarks;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(countWords * 5);
        int j = 0;
        for (int i = 0; i < countWords - 1; i++) {
            str.append(words[i]);
            if (marks[j] != null && i == marks[j].getPosition()) {
                str.append(marks[j] + " ");
                j++;
            } else
                str.append(" ");
        }
        str.append(words[countWords - 1] + String.valueOf(type));
        return new String(str);
    }
}
