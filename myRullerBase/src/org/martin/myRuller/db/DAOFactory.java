/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.myRuller.db;

import org.martin.electroList.structure.ElectroList;

/**
 *
 * @author martin
 */
public interface DAOFactory<T>{
    public abstract boolean hasElements();
    public abstract void addElement(T object);
    public abstract T getFirst();
    public abstract T getLast();
    public abstract T getElementById(int id);
    public abstract T getElementByFieldName(String fieldName, Object valueToFind);
    public abstract void setElement(T element, T newElement);
    public abstract void setElement(int id, T newElement);
    public abstract ElectroList<T> getElements();
    public abstract void removeElementById(int id);
    public abstract void removeElements();
    
}
