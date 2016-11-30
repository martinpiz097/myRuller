/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.myRuller.model;

import java.io.Serializable;

/**
 *
 * @author martin
 */
public class User implements Serializable{
    private int id;
    private String nick;
    private String password;

    public User(int id, String nick, String password) {
        this(nick, password);
        this.id = id;
    }

    public User(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "nick=" + nick + ", password=" + password + '}';
    }
    
}
