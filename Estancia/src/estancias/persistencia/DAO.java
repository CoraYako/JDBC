package estancias.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected Connection con;
    protected Statement stmt;
    protected ResultSet rs;
    protected PreparedStatement ps;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "estancias_exterior";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void conectarDDBB() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            String urlDDBB = "jdbc:mysql://localhost:3306/" + DATABASE + "?userSSL=false";
            con = DriverManager.getConnection(urlDDBB, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
    }

    protected void desconectarDDBB() throws SQLException {
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
        } catch (SQLException e) {
            throw e;
        }
    }

    protected void consultarDDBB(String sql) throws SQLException, ClassNotFoundException {
        try {
            conectarDDBB();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
    }

    public void consultaPreparadaDDBB(String sql, Date fecha, Integer dias) throws ClassNotFoundException, SQLException {
        try {
            conectarDDBB();
            ps = con.prepareStatement(sql);
            ps.setDate(1, fecha);
            ps.setInt(2, dias);
            rs = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    protected void incertarModificarEliminarDDBB(String sql) throws SQLException, ClassNotFoundException, Exception {
        try {
            conectarDDBB();
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }
    }

}
