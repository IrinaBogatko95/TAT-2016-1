package task_7;
/**
 * Case, when entered string doesn't contain some rules
 */
public class NoRules extends RulesBuilder {

    /**
     * Checks for compliance with the rule
     * @param words entered string
     */
    public boolean check(String words) {
            return true;
    }

    /**
     * Output on the screen information about compliance the rule
     */
    public void print() {
        System.out.println("The string doesn't contain some rules!");
    }
}

