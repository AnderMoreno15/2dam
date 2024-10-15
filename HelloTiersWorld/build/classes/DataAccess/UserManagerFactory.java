/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Factory where its selected if the source where the users information is received is from the user data file or the database
 * @author AI - Ander and Iñigo
 * @version 1.0
 */
public class UserManagerFactory {
/**
 * @param configFile holds an String value that indicates the origin of the data that the program will read
 * @return the method corresponding to the source that holds the user data
 */
    private static final String configFile = ResourceBundle.getBundle("resources.Config").getString("SOURCE");

    /**
     * @return  user data in specified source
     * @throws  IllegalArgumentException    If the configuration file is not specified as 'Database' or 'File'
     */
    public static DataAccessible getDataAccessible() {
        try{
            if (configFile.equals("File")) {
                return new FileUserDataAccessor();
            } else if (configFile.equals("Database")){
                return new DBUserDataAccessor();
            } else {
                Logger.getLogger("UserManagerFactory").log(Level.SEVERE, "Invalid configuration: {0}", configFile);
                throw new IllegalArgumentException("Configuration must be \"File\" or \"Database\", found: " + configFile);
            }
        } catch (Exception e) {
            Logger.getLogger("UserManagerFactory").severe(e.getLocalizedMessage());
            throw new RuntimeException("Error accessing user data: " + e.getMessage());
        }
    }

}
