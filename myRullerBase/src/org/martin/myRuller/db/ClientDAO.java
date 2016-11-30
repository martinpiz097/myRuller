/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.myRuller.db;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.martin.electroList.structure.ElectroList;
import org.martin.myRuller.model.Client;
import org.martin.myRuller.model.Menstruation;
import org.martin.myRuller.model.User;
import org.martin.tigerdb.model.Cursor;

/**
 *
 * @author martin
 */
public class ClientDAO extends DAO<Client>{
    private static final String TABLE_NAME = "client";
    
    public ClientDAO() {}
    
    @Override
    public boolean hasElements(){
        return database.selectCountFrom(TABLE_NAME) > 0;
    }
    
    @Override
    public void addElement(Client cli) {
        if (cli.getId() <= 0) {
            Object selectLast = database.selectLastFrom(TABLE_NAME);
            if (selectLast == null)
                cli.setId(1);
            
            else
                cli.setId(((Client)selectLast).getId()+1);
        }
        database.insertInto(TABLE_NAME, cli);
    }

    @Override
    public Client getFirst(){
        return (Client) database.selectFirstFrom(TABLE_NAME);
    }
    
    @Override
    public Client getLast(){
        return (Client) database.selectLastFrom(TABLE_NAME);
    }
    
    public Menstruation getLastMenstruation(int idClient){
        Client cli = getElementById(idClient);
        
        if (!cli.hasMenstruations())
            return null;
        
        final int idLastMens = cli.getMenstruations().peekLast();
        return new MenstruationDAO().getElementById(idLastMens);
    }
    
    @Override
    public Client getElementById(int id) {
        return (Client) database.selectFrom(TABLE_NAME, "id", id).peekFirst();
    }

    @Override
    public Client getElementByFieldName(String fieldName, Object valueToFind) {
        return (Client) database.selectFrom(TABLE_NAME, fieldName, valueToFind).peekFirst();
    }
    
    public Client getClientByIdUser(int idUser){
        Cursor<Client> cursor = database.getCursorFrom(TABLE_NAME);
        Client next;
        
        while (cursor.hasNext()) {            
            next = cursor.next();
            if (next.getIdUser() == idUser)
                return next;
        }
        return null;
    }

    @Override
    public void setElement(Client element, Client newElement) {
        database.update(TABLE_NAME, element, newElement);
    }

    @Override
    public void setElement(int id, Client newElement) {
        database.update(TABLE_NAME, "id", id, newElement);
    }

    @Override
    public ElectroList<Client> getElements() {
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
