/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.myRuller.db;

import java.io.IOException;
import org.martin.electroList.structure.ElectroList;
import org.martin.myRuller.model.Menstruation;
import org.martin.myRuller.model.User;

/**
 *
 * @author martin
 */
public class MenstruationDAO extends DAO<Menstruation>{
    private static final String TABLE_NAME = "menstruation";
    
    public MenstruationDAO() {}
    
    @Override
    public boolean hasElements(){
        return database.selectCountFrom(TABLE_NAME) > 0;
    }
    
    @Override
    public void addElement(Menstruation mens) {
        if (mens.getId() <= 0) {
            Object selectLast = database.selectLastFrom(TABLE_NAME);
            if (selectLast == null)
                mens.setId(1);
            
            else
                mens.setId(((Menstruation)selectLast).getId()+1);
        }
        database.insertInto(TABLE_NAME, mens);
    }
    
    @Override
    public Menstruation getFirst(){
        return (Menstruation) database.selectFirstFrom(TABLE_NAME);
    }
    
    @Override
    public Menstruation getLast(){
        return (Menstruation) database.selectLastFrom(TABLE_NAME);
    }

    @Override
    public Menstruation getElementById(int id) {
        return (Menstruation) database.selectFrom(TABLE_NAME, "id", id).peekFirst();
    }

    @Override
    public Menstruation getElementByFieldName(String fieldName, Object valueToFind) {
        return (Menstruation) database.selectFrom(TABLE_NAME, fieldName, valueToFind).peekFirst();
    }

    @Override
    public void setElement(Menstruation element, Menstruation newElement) {
        database.update(TABLE_NAME, element, newElement);
    }

    @Override
    public void setElement(int id, Menstruation newElement) {
        database.update(TABLE_NAME, "id", id, newElement);
    }

    @Override
    public ElectroList<Menstruation> getElements() {
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
