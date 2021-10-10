package interfaces;

import resource.showException;

public interface IManagerDatabase {
    
    void connect(String addres, int port, String database, String user, String password) throws showException;
    
    void insert(String colums, String value, String dateType, String table) throws showException;
    
    void update(String colums, String value, int incrementID) throws showException;
    
    void update(String colums, String value) throws showException;
    
    void delete(String database, int incrementID) throws showException;
    
    String get(String colums, String table, String dateType, int incrementID) throws showException;
    
}
