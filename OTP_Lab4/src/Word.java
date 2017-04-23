import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;

/**
 * Created by Makarenko on 23.04.2017.
 */
public class Word {
    private Letter[] letters;
    private int length = 0;

    public Word() {
        letters = new Letter[5];
    }

    public Word(StringBuilder word) {
        parse(word);
    }

    public Word(Letter[] letters) {
        this.letters = letters;
        length = this.letters.length;
    }

    public Letter[] getLetters() {
        return letters;
    }

    public void setLetters(Letter[] letters) {
        this.letters = letters;
    }

    public boolean addLetter(Letter letter) {
        if(letter == null)
            return false;
        if (letters.length == this.length) {
            Letter[] temp = letters.clone();
            letters = new Letter[length * 2];
            for (int i = 0; i < length; i++)
                letters[i] = temp[i];
        }
        letters[length] = letter;
        length++;
        return true;
    }

    public int getLength() {
        return length;
    }

    public Word parse(StringBuilder word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++)
            letters[i] = new Letter(word.charAt(i));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            str.append(letters[i].toString());
        return new String(str);
    }
}
