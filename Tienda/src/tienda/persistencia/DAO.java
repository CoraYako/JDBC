package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected Connection con = null;
    protected Statement stmt = null;
    protected ResultSet rs = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void conectarDDBB() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlDDBB = "jdbc:mysql://localhost:3306/" + DATABASE + "?userSSL=false";
            con = DriverManager.getConnection(urlDDBB, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected void desconectarDDBB() throws Exception {
        try {
            if (con != null) {
                con.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    protected void insertarModificarEliminarDDBB(String sql) throws SQLException, ClassNotFoundException, Exception {
        try {
            conectarDDBB();
            stmt = con.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        } finally {
            desconectarDDBB();
        }
    }

    protected void consultarDDBB(String sql) throws ClassNotFoundException, SQLException {
        try {
            conectarDDBB();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }
    
}
