package Task_8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class consists of a method getInput, which taking values from the keyboard
 *
 * @author Bogatko Irina
 * @version 1.0
 * @since 12.10.2016
 */
public class Input {

    /**
     * method taking values from the keyboard
     */
    public ArrayList<Goods> getInput() {
        ArrayList<Goods> products = new ArrayList<>();
        boolean answer = true;
        while (answer) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter type of product: ");
            String type = scanner.nextLine();

            System.out.print("Enter name of product: ");
            String name = scanner.nextLine();

            System.out.print("Enter product quantity: ");
            int quantity = scanner.nextInt();

            System.out.print("Enter price of product: ");
            double price = scanner.nextDouble();

            Goods goods = new Goods(type, name, quantity, price);
            products.add(goods);

            System.out.println("Would you like add one more product? \n If YES, enter Y , if NO - others symbols");
            answer = oneMoreEnter();
        }
        return products;
    }

    /**
     * if entered value equal to Y - return true
     */
    public boolean oneMoreEnter() {
        Scanner scanner = new Scanner(System.in);
        String inputCommand = scanner.nextLine();
        return (inputCommand.equals("y") || inputCommand.equals("Y"));
    }
}