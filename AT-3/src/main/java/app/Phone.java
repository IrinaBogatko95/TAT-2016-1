package app;

/**
 * Contains phone of person
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 25.11.2016
 */
public class Phone {
    private String id = "0";
    private String ownerId = "";
    private String number = "";

    /**
     * Create new empty phone
     */
    public Phone() {
    }

    /**
     * Create new Phone
     *
     * @param id      id of person
     * @param ownerId owner id
     * @param number  number of person
     */
    public Phone(String id, String ownerId, String number) {
        this.id = id;
        this.ownerId = ownerId;
        this.number = number;
    }

    /**
     * @return id of person
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return owner id
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * @return number of person
     */
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
