package app;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet, which manage person
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 25.11.2016
 */
public class ManagePersonServlet extends HttpServlet {
    private final String ADD = "add";
    private final String EDIT = "edit";
    private final String DELETE = "delete";
    private final String ADD_PHONE = "add_phone";
    private final String EDIT_PHONE = "edit_phone";
    private final String DELETE_PHONE = "delete_phone";
    private static final long serialVersionUID = 1L;
    private Phonebook phonebook;

    public ManagePersonServlet() {
        super();
        try {
            this.phonebook = Phonebook.getInstance();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Name-validation
     *
     * @param person person, which will validate
     * @return validated person
     */
    private String validatePersonFMLName(Person person) {
        String error_message = "";
        if (!person.validateFMLNamePart(person.getName(), false)) {
            error_message += "Имя должно быть строкой от 1 до 150 символов из букв, цифр, знаков подчёркивания и знаков минус.<br />";
        }
        if (!person.validateFMLNamePart(person.getSurname(), false)) {
            error_message += "Фамилия должна быть строкой от 1 до 150 символов из букв, цифр, знаков подчёркивания и знаков минус.<br />";
        }
        if (!person.validateFMLNamePart(person.getMiddleName(), true)) {
            error_message += "Отчество должно быть строкой от 0 до 150 символов из букв, цифр, знаков подчёркивания и знаков минус.<br />";
        }
        return error_message;
    }

    /**
     * Number-validation
     *
     * @param number number, which will validate
     * @return validated number
     */
    private String validateNumber(String number) {
        Matcher matcher = Pattern.compile("[(0-9)+#-]{2,50}").matcher(number);
        if (matcher.matches()) {
            return "";
        } else {
            return "Требования к телефонному номеру: от 2 до 50 символов: цифра, +, -, #.";
        }
    }

    /**
     * Reaction to GET-requests
     *
     * @param request  html-request
     * @param response html-response
     * @throws ServletException defines a general exception a servlet can throw
     *                          when it encounters difficulty
     * @throws IOException      signals that an I/O exception of some sort has occurred
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("phonebook", this.phonebook);
        HashMap<String, String> jsp_parameters = new HashMap<>();

        // Manager to transfer control to different JSP (different view)
        RequestDispatcher dispatcher_for_add = request.getRequestDispatcher("/AddPerson.jsp");
        RequestDispatcher dispatcher_for_manager = request.getRequestDispatcher("/ManagePerson.jsp");
        RequestDispatcher dispatcher_for_list = request.getRequestDispatcher("/List.jsp");
        RequestDispatcher dispatcher_for_number_manager = request.getRequestDispatcher("/ManagePhone.jsp");

        // Action and Identifier of the record that is performing this action
        String action = request.getParameter("action");
        String id = request.getParameter("id");

        if ((action == null) && (id == null)) {
            request.setAttribute("jsp_parameters", jsp_parameters);
            dispatcher_for_list.forward(request, response);
        } else {
            switch (action) {
                // Add a record
                case ADD:
                    // Preparing the parameters for the JSP
                    jsp_parameters.put("current_action", "add");
                    jsp_parameters.put("next_action", "add_go");
                    jsp_parameters.put("next_action_label", "Добавить");

                    // Set the JSP parameters
                    request.setAttribute("person", new Person());
                    request.setAttribute("jsp_parameters", jsp_parameters);

                    // Transfer request to the JSP
                    dispatcher_for_add.forward(request, response);
                    break;
                // Edit a record
                case EDIT:
                    // Extract from the phone book of the edited recording information
                    Person editable_person = this.phonebook.getPerson(id);

                    // Preparing the parameters for the JSP
                    jsp_parameters.put("current_action", "edit");
                    jsp_parameters.put("next_action", "edit_go");
                    jsp_parameters.put("next_action_label", "Сохранить");

                    // Set the JSP parameters
                    request.setAttribute("person", editable_person);
                    request.setAttribute("jsp_parameters", jsp_parameters);

                    // Transfer request to the JSP
                    dispatcher_for_manager.forward(request, response);
                    break;
                // Delete a record
                case DELETE:
                    if (phonebook.deletePerson(id)) {
                        jsp_parameters.put("current_action_result", "DELETION_SUCCESS");
                        jsp_parameters.put("current_action_result_label", "Удаление выполнено успешно");
                    } else {
                        jsp_parameters.put("current_action_result", "DELETION_FAILURE");
                        jsp_parameters.put("current_action_result_label", "Ошибка удаления (возможно, запись не найдена)");
                    }
                    // Set the JSP parameters
                    request.setAttribute("jsp_parameters", jsp_parameters);

                    // Transfer request to the JSP
                    dispatcher_for_list.forward(request, response);
                    break;
                // Phone edit
                case EDIT_PHONE:
                    // Extract from the phone book of the edited recording information.
                    Phone phone = this.phonebook.getPhone(request.getParameter("phone_id"));
                    editable_person = this.phonebook.getPerson(id);

                    // Preparing the parameters for the JSP
                    jsp_parameters.put("current_action", "edit_phone");
                    jsp_parameters.put("next_action", "edit_phone_go");
                    jsp_parameters.put("next_action_label", "Сохранить");

                    // Set the JSP parameters
                    request.setAttribute("phone", phone);
                    request.setAttribute("person", editable_person);
                    request.setAttribute("jsp_parameters", jsp_parameters);

                    // Transfer request to the JSP
                    dispatcher_for_number_manager.forward(request, response);
                    break;
                // Delete number
                case DELETE_PHONE:
                    if (phonebook.deletePhone(request.getParameter("id"), request.getParameter("phone_id"))) {
                        jsp_parameters.put("current_action_result", "DELETION_SUCCESS");
                        jsp_parameters.put("current_action_result_label", "Удаление выполнено успешно");
                    } else {
                        jsp_parameters.put("current_action_result", "DELETION_FAILURE");
                        jsp_parameters.put("current_action_result_label", "Ошибка удаления (возможно, запись не найдена)");
                    }
                    // Preparing the parameters for the JSP
                    jsp_parameters.put("current_action", "edit");
                    jsp_parameters.put("next_action", "edit_go");
                    jsp_parameters.put("next_action_label", "Сохранить");

                    // Set the JSP parameters
                    request.setAttribute("person", this.phonebook.getPerson(id));
                    request.setAttribute("jsp_parameters", jsp_parameters);

                    // Transfer request to the JSP
                    dispatcher_for_manager.forward(request, response);
                    break;
                //Add number
                case ADD_PHONE:
                    editable_person = this.phonebook.getPerson(id);

                    // Preparing the parameters for the JSP
                    jsp_parameters.put("current_action", "add_phone");
                    jsp_parameters.put("next_action", "add_phone_go");
                    jsp_parameters.put("next_action_label", "Добавить");

                    // Set the JSP parameters
                    request.setAttribute("phone", new Phone());
                    request.setAttribute("person", editable_person);
                    request.setAttribute("jsp_parameters", jsp_parameters);

                    // Transfer request to the JSP
                    dispatcher_for_number_manager.forward(request, response);
                    break;
            }
        }

    }

    /**
     * Reaction to POST-requests
     *
     * @param request  html-request
     * @param response html-response
     * @throws ServletException defines a general exception a servlet can throw
     *                          when it encounters difficulty
     * @throws IOException      signals that an I/O exception of some sort has occurred
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("phonebook", this.phonebook);
        HashMap<String, String> jsp_parameters = new HashMap<>();

        // Manager to transfer control to different JSP (different view)
        RequestDispatcher dispatcher_for_add = request.getRequestDispatcher("/AddPerson.jsp");
        RequestDispatcher dispatcher_for_manager = request.getRequestDispatcher("/ManagePerson.jsp");
        RequestDispatcher dispatcher_for_list = request.getRequestDispatcher("/List.jsp");
        RequestDispatcher dispatcher_for_number_manager = request.getRequestDispatcher("/ManagePhone.jsp");

        // Action and Identifier of the record that is performing this action
        String add_go = request.getParameter("add_go");
        String edit_go = request.getParameter("edit_go");
        String add_phone_go = request.getParameter("add_phone_go");
        String edit_phone_go = request.getParameter("edit_phone_go");
        String id = request.getParameter("id");

        // Add a record
        if (add_go != null) {
            Person updatable_person = new Person(request.getParameter("name"),
                    request.getParameter("surname"),
                    request.getParameter("middlename"));
            String error_message = this.validatePersonFMLName(updatable_person);

            if (error_message.equals("")) {
                if (this.phonebook.addPerson(updatable_person)) {
                    jsp_parameters.put("current_action_result", "ADDITION_SUCCESS");
                    jsp_parameters.put("current_action_result_label", "Добавление выполнено успешно");
                } else {
                    jsp_parameters.put("current_action_result", "ADDITION_FAILURE");
                    jsp_parameters.put("current_action_result_label", "Ошибка добавления");
                }
                // Set the JSP parameters
                request.setAttribute("jsp_parameters", jsp_parameters);

                // Transfer request to the JSP
                dispatcher_for_list.forward(request, response);
            } else {
                // Preparing the parameters for the JSP
                jsp_parameters.put("current_action", "add");
                jsp_parameters.put("next_action", "add_go");
                jsp_parameters.put("next_action_label", "Добавить");
                jsp_parameters.put("error_message", error_message);

                // Set the JSP parameters
                request.setAttribute("person", updatable_person);
                request.setAttribute("jsp_parameters", jsp_parameters);

                // Transfer request to the JSP
                dispatcher_for_add.forward(request, response);
            }
        }
        // Edit a record
        if (edit_go != null) {
            Person updatable_person = this.phonebook.getPerson(request.getParameter("id"));
            updatable_person.setName(request.getParameter("name"));
            updatable_person.setSurname(request.getParameter("surname"));
            updatable_person.setMiddleName(request.getParameter("middlename"));

            String error_message = this.validatePersonFMLName(updatable_person);

            if (error_message.equals("")) {
                if (this.phonebook.updatePerson(id, updatable_person)) {
                    jsp_parameters.put("current_action_result", "UPDATE_SUCCESS");
                    jsp_parameters.put("current_action_result_label", "Обновление выполнено успешно");
                } else {
                    jsp_parameters.put("current_action_result", "UPDATE_FAILURE");
                    jsp_parameters.put("current_action_result_label", "Ошибка обновления");
                }
                // Set the JSP parameters
                request.setAttribute("jsp_parameters", jsp_parameters);

                // Transfer request to the JSP
                dispatcher_for_list.forward(request, response);
            } else {
                // Preparing the parameters for the JSP
                jsp_parameters.put("current_action", "edit");
                jsp_parameters.put("next_action", "edit_go");
                jsp_parameters.put("next_action_label", "Сохранить");
                jsp_parameters.put("error_message", error_message);

                // Set the JSP parameters
                request.setAttribute("person", updatable_person);
                request.setAttribute("jsp_parameters", jsp_parameters);

                // Transfer request to the JSP
                dispatcher_for_manager.forward(request, response);
            }
        }
        // Add number
        if (add_phone_go != null) {
            Phone new_phone = getPhone(request);
            Person updatable_person = this.phonebook.getPerson(request.getParameter("id"));
            String error_message = validateNumber(new_phone.getNumber());

            // Preparing the parameters for the JSP
            jsp_parameters.put("current_action", "edit");
            jsp_parameters.put("next_action", "edit_go");
            jsp_parameters.put("next_action_label", "Сохранить");

            Person editable_person = this.phonebook.getPerson(id);

            // Set the JSP parameters
            request.setAttribute("phone", new Phone());
            request.setAttribute("person", editable_person);
            request.setAttribute("jsp_parameters", jsp_parameters);

            if (error_message.equals("")) {
                if (this.phonebook.addPhone(new_phone)) {
                    jsp_parameters.put("current_action_result", "ADDITION_SUCCESS");
                    jsp_parameters.put("current_action_result_label", "Добавление выполнено успешно");
                } else {
                    jsp_parameters.put("current_action_result", "ADDITION_FAILURE");
                    jsp_parameters.put("current_action_result_label", "Ошибка добавления");
                }
                // Set the JSP parameters
                request.setAttribute("person", updatable_person);
                request.setAttribute("jsp_parameters", jsp_parameters);

                // Transfer request to the JSP
                dispatcher_for_manager.forward(request, response);
            } else {
                // Set the JSP parameters
                jsp_parameters.put("current_action", "add_phone");
                jsp_parameters.put("next_action", "add_phone_go");
                jsp_parameters.put("next_action_label", "Сохранить");
                request.setAttribute("jsp_parameters", jsp_parameters);
                request.setAttribute("phone", new_phone);
                request.setAttribute("person", updatable_person);
                jsp_parameters.put("error_message", error_message);
                dispatcher_for_number_manager.forward(request, response);
            }
        }
        //Edit number
        if (edit_phone_go != null) {
            Person updatable_person = this.phonebook.getPerson(request.getParameter("id"));
            Phone new_phone = getPhone(request);

            // Set the JSP parameters
            request.setAttribute("phone", new_phone);
            request.setAttribute("person", updatable_person);
            request.setAttribute("jsp_parameters", jsp_parameters);

            // Preparing the parameters for the JSP
            jsp_parameters.put("current_action", "edit");
            jsp_parameters.put("next_action", "edit_go");
            jsp_parameters.put("next_action_label", "Сохранить");

            String error_message = validateNumber(new_phone.getNumber());

            if (error_message.equals("")) {
                if (this.phonebook.updatePhone(new_phone)) {
                    jsp_parameters.put("current_action_result", "UPDATE_SUCCESS");
                    jsp_parameters.put("current_action_result_label", "Обновление выполнено успешно");
                } else {
                    jsp_parameters.put("current_action_result", "UPDATE_FAILURE");
                    jsp_parameters.put("current_action_result_label", "Ошибка обновления");
                }
                // Set the JSP parameters
                request.setAttribute("jsp_parameters", jsp_parameters);

                // Transfer request to the JSP
                dispatcher_for_manager.forward(request, response);
            } else {
                // Set the JSP parameters
                jsp_parameters.put("current_action", "edit_phone");
                jsp_parameters.put("next_action", "edit_phone_go");
                jsp_parameters.put("next_action_label", "Сохранить");
                request.setAttribute("jsp_parameters", jsp_parameters);
                request.setAttribute("phone", new_phone);
                request.setAttribute("person", updatable_person);
                jsp_parameters.put("error_message", error_message);
                dispatcher_for_number_manager.forward(request, response);
            }
        }
    }

    /**
     * Method gets phone number of person
     *
     * @param request html-request
     * @return requested phone
     */
    private Phone getPhone(HttpServletRequest request) {
        String id = request.getParameter("phone_id");
        String owner = request.getParameter("id");
        String number = request.getParameter("number");
        return new Phone(id, owner, number);
    }
}