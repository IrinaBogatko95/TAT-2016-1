package app;

import util.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Phonebook with persons and their numbers
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 25.11.2016
 */
public class Phonebook {
    private HashMap<String, Person> persons = new HashMap<String, Person>();
    private DBWorker db = DBWorker.getInstance();
    private static Phonebook instance = null;

    /**
     * Method for the instance (implemented Singleton).
     *
     * @return Phonebook instance
     * @throws ClassNotFoundException if Phonebook not found
     * @throws SQLException           if problem with SQL
     */
    public static Phonebook getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new Phonebook();
        }
        return instance;
    }

    /**
     * Create new Phonebook, retrieved from the database all the records
     *
     * @throws ClassNotFoundException if Phonebook not found
     * @throws SQLException           if problem with SQL
     */
    protected Phonebook() throws ClassNotFoundException, SQLException {
        ResultSet db_data = this.db.getDBData("SELECT * FROM `person` ORDER BY `surname` ASC");
        while (db_data.next()) {
            this.persons.put(db_data.getString("id"),
                    new Person(db_data.getString("id"),
                            db_data.getString("name"),
                            db_data.getString("surname"),
                            db_data.getString("middlename")));
        }
    }

    /**
     * Add record about person
     *
     * @param person requested person
     */
    public boolean addPerson(Person person) {
        String query;
        if (!person.getMiddleName().equals("")) {
            query = "INSERT INTO `person` (`name`, `surname`, `middlename`) VALUES ('" + person.getName() + "', '"
                    + person.getSurname() + "', '" + person.getMiddleName() + "')";
        } else {
            query = "INSERT INTO `person` (`name`, `surname`) VALUES ('" + person.getName() + "', '"
                    + person.getSurname() + "')";
        }

        Integer affected_rows = this.db.changeDBData(query);

        if (affected_rows > 0) {
            person.setId(this.db.getLastInsertId().toString());
            this.persons.put(person.getId(), person);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Update record about person
     *
     * @param id     id of person
     * @param person requested person
     */
    public boolean updatePerson(String id, Person person) {
        Integer id_filtered = Integer.parseInt(person.getId());
        String query;
        if (!person.getMiddleName().equals("")) {
            query = "UPDATE `person` SET `name` = '" + person.getName() + "', `surname` = '" + person.getSurname()
                    + "', `middlename` = '" + person.getMiddleName() + "' WHERE `id` = " + id_filtered;
        } else {
            query = "UPDATE `person` SET `name` = '" + person.getName() + "', `surname` = '" + person.getSurname()
                    + "' WHERE `id` = " + id_filtered;
        }
        Integer affected_rows = this.db.changeDBData(query);

        if (affected_rows > 0) {
            this.persons.put(person.getId(), person);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Delete record about person
     *
     * @param id id of person
     */
    public boolean deletePerson(String id) {
        if ((id != null) && (!id.equals("null"))) {
            int filtered_id = Integer.parseInt(id);

            Integer affected_rows = this.db.changeDBData("DELETE FROM `person` WHERE `id`=" + filtered_id);

            if (affected_rows > 0) {
                this.persons.remove(id);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Add phone number
     *
     * @param phone phone number of person
     */
    public boolean addPhone(Phone phone) {
        String query = "INSERT INTO `phone` (`owner`, `number`) VALUES ('" + phone.getOwnerId() + "', '" + phone.getNumber() + "')";

        Integer affected_rows = this.db.changeDBData(query);

        if (affected_rows > 0) {
            phone.setId(db.getLastInsertId().toString());
            this.persons.get(phone.getOwnerId()).getPhones().add(phone);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Update phone number
     *
     * @param phone phone number of person
     */
    public boolean updatePhone(Phone phone) {
        Integer id = Integer.parseInt(phone.getId());
        String query = "UPDATE `phone` SET `number` = '" + phone.getNumber() + "' WHERE `id` = " + id;

        Integer affected_rows = this.db.changeDBData(query);

        if (affected_rows > 0) {
            this.persons.get(phone.getOwnerId()).getPhone(phone.getId()).setNumber(phone.getNumber());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Update phone number
     *
     * @param ownerId
     * @param id      id of person
     */
    public boolean deletePhone(String ownerId, String id) {
        if ((id != null) && (!id.equals("null"))) {
            int filtered_id = Integer.parseInt(id);

            Integer affected_rows = this.db.changeDBData("DELETE FROM `phone` WHERE `id`=" + filtered_id);

            if (affected_rows > 0) {
                this.persons.get(ownerId).deletePhone(id);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * @param id id of person
     * @return phone number of person
     */
    public Phone getPhone(String id) {
        int filtered_id = Integer.parseInt(id);
        ResultSet db_data = this.db.getDBData("SELECT * FROM `phone` WHERE `id`=" + filtered_id);
        try {
            db_data.next();
            return new Phone(db_data.getString("id"), db_data.getString("owner"), db_data.getString("number"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return list of persons
     */
    public HashMap<String, Person> getContents() {
        return persons;
    }

    /**
     * @param id id of person
     * @return required person
     */
    public Person getPerson(String id) {
        return this.persons.get(id);
    }
}
