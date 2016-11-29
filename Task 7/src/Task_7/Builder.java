package Task_7;
import java.util.ArrayList;

/**
 *Contain methods "buildRules" and "checkToRules"
 */
public class Builder {

    /**
     * Makes a list of rules
     */
    public static ArrayList<RulesBuilder> buildRules() {
        ArrayList<RulesBuilder> allRules = new ArrayList<>();
        allRules.add(new NoFigures());
        allRules.add(new OnlyFigures());
        allRules.add(new MoreFiveWords());
        allRules.add(new WordFromVocabulary());
        return allRules;
    }

    /**
     * Check entered string to compliance with rules.
     * If appropriate rule - displays.
     * @param allRules all rules in list
     * @param enteredString entered string
     */
    public static void checkToRules(ArrayList<RulesBuilder> allRules, String enteredString) {
        int count = 0;
        for (RulesBuilder rule : allRules) {
            if (rule.check(enteredString)) {
                rule.print();
                count++;
            }
        }
        if(count == 0){
            System.out.println("The string doesn't contains some rules!");
        }
    }
}
