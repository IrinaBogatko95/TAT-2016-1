package Task_7;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class consists of method, which checks, that parameters contains only figures
 */
public class OnlyFigures extends RulesBuilder {

    /**
     * Checks for compliance with the rule
     *
     * @param words entered string
     */
    public boolean check(String words) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(words);
        return matcher.matches();
    }

    /**
     * Output on the screen information about compliance the rule
     */
    public void print() {
        System.out.println("String complies to rule 2.");
    }
}