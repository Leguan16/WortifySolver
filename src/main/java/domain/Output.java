package domain;

import java.util.List;

public class Output {

    private final int todaysWortifyLength;

    private final List<String> words;

    public Output(List<String> words) {
        this.words = words;
        this.todaysWortifyLength = words.size();
    }

    public int getTodaysWortifyLength() {
        return todaysWortifyLength;
    }

    public List<String> getWords() {
        return words;
    }
}
