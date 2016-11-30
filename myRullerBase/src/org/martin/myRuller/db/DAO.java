/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.myRuller.db;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.martin.myRuller.model.Client;
import org.martin.myRuller.model.Menstruation;
import org.martin.myRuller.model.User;
import org.martin.tigerdb.model.Database;

/**
 *
 * @author martin
 */
public abstract class DAO<T> implements DAOFactory<T>{
    private static final String DB_NAME = "dbRuller";
    protected final Database database;

    // Se asegura su ejecución solo una vez en el programa para verificar
    // que la base de datos está disponible.
    static{
        try {
            loadScript();
        } catch (IOException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected DAO() {
        database = new Database(DB_NAME);
    }
    
    private static void loadScript() throws IOException{
        Database database = new Database(DB_NAME);
        int tableCount = database.getTableCount();
        
        if (database.hasTables())
            if (tableCount == 3)
                return;
            else
                database.dropAllTables();
        
        database.createTable("client", Client.class);
        database.createTable("user", User.class);
        database.createTable("menstruation", Menstruation.class);
    }
}
