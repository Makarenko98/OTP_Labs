import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Makarenko on 23.04.2017.
 */
public class Text {
    private Sentence[] sentences;
    private int count;

    public Text() {
        sentences = new Sentence[5];
    }

    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public Text(StringBuilder text) {
        sentences = new Sentence[5];
        parse(text);
    }

    public int getCount() {
        return count;
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    public void setSentences(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public boolean addSentence(Sentence sentence) {
        if(sentence == null)
            return false;
        if (sentences.length == this.count) {
            Sentence[] temp = sentences.clone();
            sentences = new Sentence[count * 2];
            for (int i = 0; i < count; i++)
                sentences[i] = temp[i];
        }
        sentences[count] = sentence;
        count++;
        return true;
    }

    public Text parse(StringBuilder text) {
        int posBegSentence = 0;
        int posEndSentence = -1;
        char sentenceType;
        boolean flag = true;
        while (flag) {
            posBegSentence = posEndSentence + 1;
            for (int i = posBegSentence; i < text.length(); i++) {
                if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?') {
                    posEndSentence = i;
                    break;
                }
                if (i == text.length() - 1)
                    flag = false;
            }
            if (!flag || posBegSentence == text.length())
                break;
            if (posEndSentence - posBegSentence < 2)
                continue;
            addSentence(new Sentence(new StringBuilder(text.substring(posBegSentence, posEndSentence + 1))));
        }

        return this;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(count * 20);
        for (int i = 0; i < count - 1; i++) {
            str.append(sentences[i] + " ");
        }
        str.append(sentences[count - 1]);
        return new String(str);
    }
}
