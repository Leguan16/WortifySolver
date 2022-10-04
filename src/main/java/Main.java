import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import domain.Wortify;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();

        Path path = new File(Objects.requireNonNull(Main.class
                        .getResource("/letters.json"))
                .getFile()).toPath();

        Path pathToWordList = new File(Objects.requireNonNull(Main.class
                        .getResource("/wordlist.json"))
                .getFile()).toPath();

        Path pathToHaveAlready = new File(Objects.requireNonNull(Main.class
                        .getResource("/havealready.txt"))
                .getFile()).toPath();

        Wortify wortify = gson.fromJson(Files.readString(path), Wortify.class);

        List<String> words = gson.fromJson(Files.readString(pathToWordList), new TypeToken<List<String>>() {
        }.getType());

        String patten = "[" + wortify.getRequired() + wortify.getLettersJoint() + "]+";

        List<String> haveAlready = Arrays.stream(Files.readString(pathToHaveAlready).split(" "))
                .map(String::trim)
                .map(String::toLowerCase)
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        System.out.println(words.parallelStream()
                .map(String::toLowerCase)
                .map(String::trim)
                .filter(word -> !haveAlready.contains(word))
                .filter(word -> word.contains(wortify.getRequired()))
                .filter(word -> word.matches(patten))
                .filter(word -> word.length() > 3)
                .sorted(Comparator.comparingInt(String::length))
                .toList());
    }

}