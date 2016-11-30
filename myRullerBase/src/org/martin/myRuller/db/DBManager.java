///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.martin.myRuller.db;
//
//import java.io.IOException;
//import org.martin.myRuller.model.Client;
//import org.martin.myRuller.model.Menstruation;
//import org.martin.myRuller.model.User;
//import org.martin.tigerdb.model.Database;
//
///**
// *
// * @author martin
// */
//public class DBManager {
//    private final Database db;
//
//    public DBManager() throws IOException {
//        db = new Database("dbRuller");
//        loadScript();
//    }
//    
//    private void loadScript() throws IOException{
//        if (db.hasTables())
//            return;
//        
//        db.createTable("client", Client.class);
//        db.createTable("user", User.class);
//        db.createTable("menstruation", Menstruation.class);
//    }
//    
//}
