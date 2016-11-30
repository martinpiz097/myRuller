///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.martin.myruller.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import org.martin.electroList.structure.ElectroList;
//
///**
// *
// * @author martin
// */
//public class Session {
//    private final HashMap<String, Object> attributes;
//    private final ElectroList<String> attributeNames;
//    private static final Session session;
//    
//    static {
//        session = new Session();
//    }
//    
//    public static Session getSession(){
//        return session;
//    }
//    
//    private Session() {
//        attributes = new HashMap<>();
//        attributeNames = new ElectroList<>();
//    }
//
//    public HashMap<String, Object> getAttributes() {
//        return attributes;
//    }
//
//    public ElectroList<String> getAttributeName(){
//        return attributeNames;
//    }
//    
//    public Object getAttribute(String name){
//        return attributes.get(name);
//    }
//    
//    public void setAttribute(String name, Object value){
//        attributes.put(name, value);
//        if (!attributeNames.anyMatch(a->a.equals(name)))
//            attributeNames.add(name);
//    }
//
//    public void clear(){
//        attributes.clear();
//        attributeNames.clear();
//    }
//    
//}
