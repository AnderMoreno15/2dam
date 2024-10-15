/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import model.User;

/**
 * Gets the users information from the database
 * @author Ander and Iñigo F
 * @version 1.0
 */
public class DBUserDataAccessor implements DataAccessible {

    /**
     * @param username Variable where the users username is going to be stored
     * @param password Variable where the users password is going to be stored
     * @param name Variable where the users name is going to be stored
     * @param surname Variable where the users surname is going to be stored
     */
    private String username;
    private String password;
    private String name;
    private String surname;

    /**
     * @return user data read stored in the database
     */
    @Override
    public User getData() {
        String url = "jdbc:mysql://localhost:3306/dinreto0?serverTimezone=Europe/Madrid&useSSL=false";
        String userdb = "root";
        String passworddb = "root";

        try (Connection conn = DriverManager.getConnection(url, userdb, passworddb);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM usuario")) {

            while (rs.next()) {
                username = rs.getString("username");
                password = rs.getString("pwd");
                name = rs.getString("nombre");
                surname = rs.getString("apellido");
            }

        } catch (SQLException e) {
            Logger.getLogger("DBUserDataAccessor").severe(e.getLocalizedMessage());
            throw new RuntimeException("Error accessing user data: " + e.getMessage());
        }
        User user = new User(username, password, name, surname);
        return user;
    }

}
