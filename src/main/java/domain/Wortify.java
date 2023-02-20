package domain;

import java.util.List;

public class Wortify {

    private String required;
    private List<String> letters;

    public Wortify(String required, List<String> letters) {
        this.required = required;
        this.letters = letters;
        this.letters.add(required);
    }

    public Wortify(char charAt, List<String> allLetters) {
        this.required = String.valueOf(charAt);
        this.letters = allLetters;
    }

    public String getRequired() {
        return required;
    }

    public List<String> getLetters() {
        return List.copyOf(letters);
    }

    public String getLettersJoint() {
        return String.join("", letters);
    }

    @Override
    public String toString() {
        return "Wortify{" +
                "required=" + required +
                ", letters=" + letters +
                '}';
    }
}
