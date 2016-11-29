package Task_2;

/**
 * Class has a method that displays name which input from command line
 */
public class CommandLineName {

    /**
     * Output name from command line
     */
    public static void main(String[] args){
        for(int i = 0; i < args.length; i++){
            System.out.println("Hello, " + args[i]);
        }
    }
}
