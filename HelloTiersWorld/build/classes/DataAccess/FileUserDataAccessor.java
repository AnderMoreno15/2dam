/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.util.ResourceBundle;
import model.User;

/**
 * Gets the users information from the user data file
 * @author AI - Ander and Iñigo
 * @version 1.0
 */
public class FileUserDataAccessor implements DataAccessible{

    /**
     * @param configFile Variable with the link of the configuration file
     * @param username Variable where the users username is going to be stored
     * @param password Variable where the users password is going to be stored
     * @param name Variable where the users name is going to be stored
     * @param surname Variable where the users surname is going to be stored
     */
    private ResourceBundle configFile;
    private String username;
    private String password;
    private String name;
    private String surname;
    
    /**
     * @return user data read stored in the user data file
     */
    @Override
    public User getData() {
        configFile = ResourceBundle.getBundle("resources.UserData");
        username = configFile.getString("USERNAME");
        password = configFile.getString("PASSWORD");
        name = configFile.getString("NAME");
        surname = configFile.getString("SURNAME");
        
        User user = new User(username, password, name, surname);
        
        return user;
    }
    
}
