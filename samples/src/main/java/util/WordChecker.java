package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordChecker {
    private Set<String> dictionary = new HashSet<>();

    public  void loadWords() {
        // System.out.println(word);
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    "/usr/share/dict/words"));
            String str;
            while ((str = in.readLine()) != null) {
                dictionary.add(str.toLowerCase());
            }
            in.close();
        } catch (IOException e) {
        }

    }

    public boolean checkForWord(String s) {
        return dictionary.contains(s);
    }

    public static void main(String[] args) {
        WordChecker wordChecker = new WordChecker();
        wordChecker.loadWords();
        System.out.println(wordChecker.checkForWord("hello"));
    }
}