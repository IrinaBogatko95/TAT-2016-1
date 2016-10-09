package task_7;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class consists of method, which checks, that parameters contains words from vocabulary
 */
public class WordFromVocabulary extends RulesBuilder {

    /**
     * Checks for compliance with the rule
     * @param words entered string
     */
    public boolean check(String words) {
        int count = 0;
        ArrayList<String> vocabulary = new ArrayList<>();
        vocabulary.add("Hello");
        vocabulary.add("What");
        vocabulary.add("Name");
        vocabulary.add("Best");

        for (String wordVocabulary : vocabulary) {
            Pattern pattern = Pattern.compile(wordVocabulary);
            Matcher matcher = pattern.matcher(words);
            if (matcher.find()) {
                count++;
            }
        }
        return  (count > 0);
    }

    /**
     * Output on the screen information about compliance the rule
     */
    public void print() {
        System.out.println("String complies to rule 4.");
    }
}

