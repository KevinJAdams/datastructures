package phoneconverter;

import java.util.LinkedList;
import java.util.List;

public class PhoneConverter {

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
}
