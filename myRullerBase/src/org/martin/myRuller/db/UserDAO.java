/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.myRuller.db;

import java.io.IOException;
import org.martin.electroList.structure.ElectroList;
import org.martin.myRuller.model.User;

/**
 *
 * @author martin
 */
public class UserDAO extends DAO<User>{
    private static final String TABLE_NAME = "user";
    
    public UserDAO() {}
    
    @Override
    public boolean hasElements(){
        return database.selectCountFrom(TABLE_NAME) > 0;
    }
    
    @Override
    public void addElement(User cli) {
        if (cli.getId() <= 0) {
            Object selectLast = database.selectLastFrom(TABLE_NAME);
            if (selectLast == null)
                cli.setId(1);
            
            else
                cli.setId(((User)selectLast).getId()+1);
        }
        database.insertInto(TABLE_NAME, cli);
    }
    
    @Override
    public User getFirst(){
        return (User) database.selectFirstFrom(TABLE_NAME);
    }
    
    @Override
    public User getLast(){
        return (User) database.selectLastFrom(TABLE_NAME);
    }

    @Override
    public User getElementById(int id) {
        return (User) database.selectFrom(TABLE_NAME, "id", id).peekFirst();
    }

    @Override
    public User getElementByFieldName(String fieldName, Object valueToFind) {
        return (User) database.selectFrom(TABLE_NAME, fieldName, valueToFind).peekFirst();
    }

    @Override
    public void setElement(User element, User newElement) {
        database.update(TABLE_NAME, element, newElement);
    }

    @Override
    public void setElement(int id, User newElement) {
        database.update(TABLE_NAME, "id", id, newElement);
    }

    @Override
    public ElectroList<User> getElements() {
        return database.selectAllFrom(TABLE_NAME);
    }

    @Override
    public void removeElementById(int id) {
        database.deleteFrom(TABLE_NAME, "id", id);
    }

    @Override
    public void removeElements() {
        database.deleteAllFrom(TABLE_NAME);
    }
}
