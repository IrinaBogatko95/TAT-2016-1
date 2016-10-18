package task_7;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class consists of method, which checks, that parameters do not contains figures
 */
public class NoFigures extends RulesBuilder {

    /**
     * Checks for compliance with the rule
     *
     * @param words entered string
     */
    public boolean check(String words) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(words);
        return !matcher.find();

    }

    /**
     * Output on the screen information about compliance the rule
     */
    public void print() {
        System.out.println("String complies to rule 1.");
    }
}

