package matenek.epidemiologyhandbookintetum;

/**
 * Created by admin on 26/08/16.
 */
public class QuizObject {

    private String word;
    private String definition;

    public QuizObject(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }


}
