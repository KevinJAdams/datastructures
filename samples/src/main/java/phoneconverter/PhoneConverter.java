package phoneconverter;

import java.util.*;

import util.WordChecker;

public class PhoneConverter {
    WordChecker wordChecker;

    public PhoneConverter() {
        wordChecker = new WordChecker();
        wordChecker.loadWords();
    }

    List<String> getPossibleStrings(String numberStr) {
        List<String> subStrings = new LinkedList<>();

        if (numberStr.length() > 1) {
            subStrings = getPossibleStrings(numberStr.substring(1));
        }
        List<Character> newChars = getCharacters(numberStr.charAt(0));
        List<String> newStrings = new LinkedList<>();
        for (Character c : newChars) {
            if (subStrings.isEmpty()) {
                newStrings.add(c.toString());
            }
            for (String s : subStrings) {
                newStrings.add(c + s);
            }
        }
        return newStrings;
    }

    List<Character> getCharacters(char digit) {
        List<Character> characters = new LinkedList<>();
        switch (digit) {
            case '0':
                characters.add('0');
                break;
            case '1':
                characters.add('1');
                break;
            case '2' :
                characters.add('A');characters.add('B');characters.add('C');
                break;
            case '3' :
                characters.add('D');characters.add('E');characters.add('F');
                break;
            case '4' :
                characters.add('G');characters.add('H');characters.add('I');
                break;
            case '5' :
                characters.add('J');characters.add('K');characters.add('L');
                break;
            case '6' :
                characters.add('M');characters.add('N');characters.add('O');
                break;
            case '7' :
                characters.add('P');characters.add('Q');characters.add('R'); characters.add('S');
                break;
            case '8' :
                characters.add('T');characters.add('U');characters.add('V');
                break;
            case '9' :
                characters.add('W');characters.add('X');characters.add('Y'); characters.add('Z');
                break;
            default:
                characters.add(digit);
                break;
        }
        return characters;
    }

    public List<String> longestWordList(List<String> stringList, int maxLength) {
        for (int length = maxLength; length > 0; length--) {
            List<String> words = findWordsOfLength(stringList, length);
            if (words.size() > 0) {
                return words;
            }

        }
        return new ArrayList<String>();
    }

    private List<String> findWordsOfLength(List<String> stringList, int length) {
        List<String> result = new ArrayList<>();
        Set<String> stringsOfLength = new HashSet<>();
        int addedStrings = 0;
        int duplicateStrings = 0;
        for (String s : stringList) {
            List<String> substrings = findStringsOfLengthInString(s.toLowerCase(), length);
            for (String subString : substrings) {
                if(stringsOfLength.add(subString)) {
                    addedStrings++;
                } else {
                    duplicateStrings++;
                }
            }
        }

        for (String s : stringsOfLength) {
            if (wordChecker.checkForWord(s)) {
                result.add(s);
            }
        }
        return result;

    }

    private List<String> findStringsOfLengthInString(String s, int length) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= s.length()-length; i++) {
            String stringToCheck = s.substring(i, i + length);
            result.add(stringToCheck);
        }
        return result;
    }
}
