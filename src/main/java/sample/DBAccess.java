package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import net.sf.persist.Persist;

public class DBAccess {
    
    public static DBAccess instance = new DBAccess();
    private Persist persist;
    
    private DBAccess() {
        this.connectDatabase();
        this.initializeDatabase();
    }
    
    private void connectDatabase() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:test", "sa", "");
            
            this.persist = new Persist(connection);
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    private void initializeDatabase() {
        this.persist.executeUpdate("CREATE TABLE TEST_TABLE (ID INTEGER, VALUE VARCHAR(10))");
        this.persist.setAutoCommit(false);
        this.persist.executeUpdate("INSERT INTO TEST_TABLE VALUES (?, ?)", 1, "hoge");
        this.persist.executeUpdate("INSERT INTO TEST_TABLE VALUES (?, ?)", 2, "fuga");
        this.persist.executeUpdate("INSERT INTO TEST_TABLE VALUES (?, ?)", 3, "piyo");
        this.persist.commit();
    }
    
    public List<Map<String, Object>> readList() {
        return this.persist.readMapList("SELECT * FROM TEST_TABLE");
    }
}
