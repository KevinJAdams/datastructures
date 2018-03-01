package phoneconverter;

import java.util.List;

public class PhoneConverterTest {
    public static void main(String[] args) {
        if (args.length > 0) {
            PhoneConverter converter = new PhoneConverter();
            List<String> options = converter.getPossibleStrings(args[0]);
            for (String option: options)
            {
                System.out.println(option);
            }
            List<String> longestWordList = converter.longestWordList(options, args[0].length());
            for (String word: longestWordList) {
                System.out.println("Longest Word: " + word);
            }
        }
    }
}
