import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Makarenko on 21.04.2017.
 */
public class TextAnalyzer {
    private Text text;
    private Word[] words;
    private int count = 0;

    public TextAnalyzer() {
        words = new Word[5];
    }

    public TextAnalyzer(Text text) {
        words = new Word[5];
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        words = new Word[5];
        this.text = text;
    }

    public Word[] FindWords(int length) {
        Sentence sentence;
        for(int i=0;i<this.text.getCount();i++){
            sentence = this.text.getSentences()[i];
            if(sentence.getType()=='?'){
                for(int j=0;j<sentence.getCountWords();j++)
                    if(sentence.getWords()[j].getLength() == length)
                        addWord(sentence.getWords()[j]);
            }
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

    private void addWord(Word word) {
        if (words.length == this.count) {
            Word[] temp = words.clone();
            words = new Word[count * 2];
            for (int i = 0; i < count; i++)
                words[i] = temp[i];
        }
        words[count] = word;
        count++;
    }

    public Word[] getWords() {
        return words;
    }

    public int getCount() {
        return count;
    }
}