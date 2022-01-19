package za.co.bakery.manager;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Studio13
 */
public class DBPoolManagerBasic {

    private BasicDataSource dataSource;

    public DBPoolManagerBasic(
            String driver,
            String url,
            String username,
            String password) {
        // public DBPoolManagerBasic() {
        try {
//       Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName(driver);
            dataSource = new BasicDataSource();
//      dataSource.setUrl("jdbc:mysql://localhost:3306/mrspatbakerydb?useSSL=false");
//      dataSource.setUsername("root");
//      dataSource.setPassword("root");
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setMinIdle(5);
            dataSource.setMaxIdle(10);
            dataSource.setMaxOpenPreparedStatements(100);
            System.out.println("Setup datasource ----------------------------------------");
        } catch (ClassNotFoundException ex) {
            System.out.println("Rats!! cannot load driver: " + ex);
        }
    }

    // *******************************************
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // *******************************************
    public void closePool() {
        if (this.dataSource != null) {
            try {
                this.dataSource.close();
            } catch (SQLException ex) {
                System.out.println("ERROR closing connection " + ex.getMessage());
            }
        }
    }
    // *******************************************

}
