/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import model.User;

/**
 * Gets the data from the user
 * @author AI - Ander and Iñigo
 * @version 1.0
 */
public interface DataAccessible {
    /**
     * @return  data of the user
     */
    public User getData();
}
