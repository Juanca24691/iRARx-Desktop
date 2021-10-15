package interfaces;

public interface IManagerDatabase {
    
    void connect(String addres, int port, String database, String user, String password) throws resource.showException;
    
    void insert(String colums, String value, String dateType, String table) throws resource.showException;
    
    void update(String colums, String value, int incrementID) throws resource.showException;
    
    void update(String colums, String value) throws resource.showException;
    
    void delete(String database, int incrementID) throws resource.showException;
    
    String get(String colums, String table, String dateType, int incrementID) throws resource.showException;
    
}
