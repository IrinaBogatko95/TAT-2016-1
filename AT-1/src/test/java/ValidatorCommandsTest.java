package instructions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ValidatorCommandsTest {

    @DataProvider(name = "Positive provider")
    public Object[][]positiveTestDoCommand() {
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new Command("Open", "http://www.google,com", "3"));
        commands.add(new Command("CheckPageTitle", "http://www.google,com", "Google"));
        return new Object[][] {
                {commands}
    };
    }

    @DataProvider(name = "Negative provider")
    public Object[][]negativeTestDoCommand() {
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new Command("Open", "ww.google,com", "fff"));
        commands.add(new Command(null, null, null));
        commands.add(new Command("CheckPageContains", "http://www.google.com", null));
        commands.add(new Command("Open", "www.google,com", "-10"));
        commands.add(new Command("Open", "www.google.com", "0.1"));
        commands.add(new Command("Open", "www.google.com", "0.,1"));
        commands.add(new Command("Open", "www.google.com", "00000001"));
        commands.add(new Command("Open", "1", "-2"));
        return new Object[][] {
                {commands}
        };
    }

    @Test (dataProvider = "Positive provider")
    public void positiveTestValidate(ArrayList<Command> commands) throws Exception {
        ValidatorCommands validatorCommands = new ValidatorCommands();
        validatorCommands.validate(commands);
    }

    @Test (dataProvider = "Negative provider", expectedExceptions = Exception.class)
    public void negativeTestValidate(ArrayList<Command> commands) throws Exception {
        ValidatorCommands validatorCommands = new ValidatorCommands();
        validatorCommands.validate(commands);
    }

}