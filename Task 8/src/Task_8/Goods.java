package Task_8;

/**
 * Class which consist of fields type, name, quantity and price
 *
 * @author Bogatko Irina
 * @version 1.0
 * @since 12.10.2016
 */
public class Goods {
    private String type;
    private String name;
    private int quantity;
    private double price;

    /**
     * Constructor of class Goods
     *
     * @param type     type of product
     * @param name     name of product
     * @param quantity quantity of product
     * @param price    price of product
     */
    public Goods(String type, String name, int quantity, double price) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Get type of product
     */
    public String getType() {
        return type;
    }

    /**
     * Get quantity of product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Get price of product
     */
    public double getPrice() {
        return price;
    }
}