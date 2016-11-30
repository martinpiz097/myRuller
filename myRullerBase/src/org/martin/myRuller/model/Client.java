/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.myRuller.model;

import java.io.Serializable;
import org.martin.electroList.structure.ElectroList;

/**
 *
 * @author martin
 */
public class Client implements Serializable{
    private int id;
    private String name;
    private byte age;
    private final ElectroList<Integer> menstruations;
    private int idUser;
    
    public Client(int id, String name, byte age, int idUser) {
        this(name, age, idUser);
        this.id = id;
    }

    public Client(String name, byte age, int idUser) {
        this.name = name;
        this.age = age;
        menstruations = new ElectroList<>();
        this.idUser = idUser;
    }
    
    public boolean hasMenstruations(){
        return !menstruations.isEmpty();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }
    
    public void setAge(byte age){
        this.age = age;
    }

    public ElectroList<Integer> getMenstruations() {
        return menstruations;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    
}
