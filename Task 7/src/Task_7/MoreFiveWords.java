package Task_7;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class consists of method, which checks, that parameters contains more than five words
 */
public class MoreFiveWords extends RulesBuilder {
    final int CONST = 5;

    /**
     * Checks for compliance with the rule
     * @param words entered string
     */
    public boolean check(String words) {
        int count = 0;
        Pattern pattern = Pattern.compile("\\s+");
        Pattern pattern2 = Pattern.compile("\\p{Punct}");
        Matcher matcher = pattern.matcher(words);
        Matcher matcher2 = pattern2.matcher(words);

        while (matcher.find() || matcher2.find()) {
            count++;
        }
        return  (count + 1 > CONST);
    }

    /**
     * Output on the screen information about compliance the rule
     */
    public void print() {
        System.out.println("String complies to rule 3.");
    }
}

