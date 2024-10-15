/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * @author AI - Ander and Iñigo
 * @version 1.0
 */
public class User {

    /**
     * @param username user's username for login
     * @param password user's password for login
     * @param name user's real name
     * @param surname user's real surname
     */
    private String username;
    private String password;
    private String name;
    private String surname;

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    /**
     *
     * @return user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username sets user's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return user's username
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password sets user's username
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return user's username
     */
    public String getName() {
        return name;
    }

    /**
     * @param name sets user's username
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return user's username
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname sets user's username
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

}
