package managerDatabase;

import interfaces.IManagerDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import resource.showException;

public class connectDatabase implements IManagerDatabase{
    
    String URL;
    String databaseName;
    Connection connection;
    Statement instruction;
    ResultSet result;

    @Override
    public void connect(String addres, int port, String database, String user, String password) {
        try {
            this.URL = "jdbc:mysql://" + addres + ":" + Integer.toString(port) + "/" + database + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            this.connection = DriverManager.getConnection(this.URL, user, password);
            this.databaseName = database;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void insert(String colums, String value, String dateType, String table) throws showException {
        
    }

    @Override
    public void update(String colums, String value, int incrementID) throws showException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String colums, String value) throws showException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String database, int incrementID) throws showException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String get(String colums, String table, String dateType, int incrementID) {
        var select = "SELECT" + " " + colums + " " + "FROM" + " " + this.databaseName + "." + table + " " + "WHERE ID =" + " " + String.valueOf(incrementID) + ";";
        
        String value = "sin asignar";
        
        try {
            this.instruction = connection.createStatement();
            this.result = instruction.executeQuery(select);
            
            while (this.result.next()) {
                value = this.result.getString(colums);
            }
            
            this.instruction.close();
            this.result.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return value;
    }
    
}
