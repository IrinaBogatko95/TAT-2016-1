package task_7;
/**
 * Contain abstract methods "check" and "print"
 */
public abstract class RulesBuilder {

    /**
     * Checks for compliance with the rule
     *
     * @param param entered string
     */
    public abstract boolean check(String param);

    /**
     * Output on the screen information about compliance the rule
     */
    public abstract void print();
}
