package app;

import util.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Person from phonebook
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 25.11.2016
 */
public class Person {
    private String id = "";
    private String name = "";
    private String surname = "";
    private String middleName = "";
    private List<Phone> phones = new ArrayList<>();

    /**
     * Create new Person
     *
     * @param id         id of person
     * @param surname    surname of person
     * @param middleName middle name of person
     */
    public Person(String id, String name, String surname, String middleName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;

        // Get numbers from database
        ResultSet db_data = DBWorker.getInstance().getDBData("SELECT * FROM `phone` WHERE `owner`=" + id);
        try {
            if (db_data != null) {
                while (db_data.next()) {
                    this.phones.add(new Phone(db_data.getString("id"),
                            db_data.getString("owner"),
                            db_data.getString("number")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create new empty Person
     */
    public Person() {
        this.id = "0";
        this.name = "";
        this.surname = "";
        this.middleName = "";
    }

    /**
     * Create new Person, which intended to be added to the database
     *
     * @param name       name of person
     * @param surname    surname of person
     * @param middleName middle name of person
     */
    public Person(String name, String surname, String middleName) {
        this.id = "0";
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;

    }

    /**
     * Name-validation
     *
     * @param fml_name_part part of name of person
     * @param empty_allowed define can be empty or not
     * @return validated number
     */
    public boolean validateFMLNamePart(String fml_name_part, boolean empty_allowed) {
        if (empty_allowed) {
            if (!fml_name_part.equals("")) {
                Matcher matcher = Pattern.compile("[а-яА-ЯёЁ+(-|_)]{1,150}").matcher(fml_name_part);
                return matcher.matches();
            } else {
                return true;
            }
        } else {
            Matcher matcher = Pattern.compile("[а-яА-ЯёЁ+(-|_)]{1,150}").matcher(fml_name_part);
            return matcher.matches();
        }
    }

    /**
     * @return id of person
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return name of person
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return surname of person
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * @return middle name of person
     */
    public String getMiddleName() {
        if ((this.middleName != null) && (!this.middleName.equals("null"))) {
            return this.middleName;
        } else {
            return "";
        }
    }

    /**
     * @return list of phones of person
     */
    public List<Phone> getPhones() {
        return phones;
    }

    /**
     * Delete phones of person
     *
     * @param id id of person
     */
    public void deletePhone(String id) {
        Iterator<Phone> iterator = phones.iterator();
        while (iterator.hasNext()) {
            Phone phone = iterator.next();
            if (phone.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    /**
     * @return requested phone of person
     */
    public Phone getPhone(String id) {
        for (Phone phone : phones) {
            if (phone.getId().equals(id)) {
                return phone;
            }
        }
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
