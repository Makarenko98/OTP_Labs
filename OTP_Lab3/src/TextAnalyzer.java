import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Makarenko on 21.04.2017.
 */
public class TextAnalyzer {
    private StringBuilder text;
    private StringBuilder[] words;
    private int count = 0;

    public TextAnalyzer() {
        words = new StringBuilder[5];
    }

    public TextAnalyzer(StringBuilder text) {
        words = new StringBuilder[5];
        this.text = text;
    }

    public StringBuilder getText() {
        return text;
    }

    public void setText(StringBuilder text) {
        words = new StringBuilder[5];
        this.text = text;
    }

    public StringBuilder[] FindWords(int length) {
        if (text == null || text.length() == 0 || text.length() <= length)
            return null;
//            throw new IllegalArgumentException();

        boolean flag = true;
        boolean sentenceType = false; // = true if interrogative sentence
        int posBegSentence = 0, posEndSentence = -1;
        int wordLen = 0;
        while (flag) {
            posBegSentence = posEndSentence + 1;
            for (int i = posBegSentence; i < text.length(); i++) {
                if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?') {
                    posEndSentence = i;
                    sentenceType = text.charAt(i) == '?';
                    break;
                }
                if (i == text.length() - 1)
                    flag = false;
            }
            if (!flag)
                break;
            if (!sentenceType)
                continue;
            for (int i = posBegSentence; i < posEndSentence; i++) {
                if (!isLetter(i)) {
                    wordLen = 0;
                    continue;
                }
                wordLen++;
                if (wordLen == length && !isLetter(i + 1)) {
                    addWord(new StringBuilder(text.substring(i - (length - 1), i + 1)));
                    wordLen = 0;
                }
            }
            if (posEndSentence == text.length() - 1)
                break;

        }

        return words;
    }

    public void printWords() {
        if (words == null)
            return;
        if (count == 0) {
            System.out.println("Words not found");
            return;
        }
        for (int i = 0; i < count; i++)
            System.out.println((i + 1) + ". " + words[i]);
    }

    private boolean isLetter(int n) {
        return !(text.charAt(n) == ' ' || text.charAt(n) == ',' || text.charAt(n) == ':' || text.charAt(n) == ';'
                || text.charAt(n) == '-' || text.charAt(n) == '.' || text.charAt(n) == '!' || text.charAt(n) == '?');
    }

    private boolean addWord(StringBuilder word) {
        if (word == null)
            return false;
        if (words.length == this.count) {
            StringBuilder[] temp = words.clone();
            words = new StringBuilder[count * 2];
            for (int i = 0; i < count; i++)
                words[i] = temp[i];
        }
        words[count] = word;
        count++;
        return true;
    }

    public StringBuilder[] getWords() {
        return words;
    }

    public int getCount() {
        return count;
    }
}
