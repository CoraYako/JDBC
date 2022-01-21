package tienda.persistencia;

import java.sql.SQLException;
import tienda.entidades.Fabricante;

public final class FabricanteDAO extends DAO {

    public void guardarFabricanteDDBB(Fabricante fabricante) throws Exception {
        try {
            String sql = "INSERT INTO tienda.fabricante (nombre) VALUES ('"
                    + fabricante.getNombre() + "');";

            insertarModificarEliminarDDBB(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {
        Fabricante fabricante = new Fabricante();

        try {
            String sql = "SELECT * FROM tienda.fabricante WHERE codigo = '"
                    + codigo + "';";

            consultarDDBB(sql);

            while (rs.next()) {

                fabricante.setCodigo(rs.getInt(1));
                fabricante.setNombre(rs.getString(2));
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return fabricante;
    }

    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {
        Fabricante fabricante = new Fabricante();

        try {
            String sql = "SELECT * FROM tienda.fabricante WHERE nombre = '"
                    + nombre + "';";

            consultarDDBB(sql);

            while (rs.next()) {

                fabricante.setCodigo(rs.getInt(1));
                fabricante.setNombre(rs.getString(2));
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return fabricante;
    }

    public Fabricante ultimoFabricanteAgregado() throws Exception {
        Fabricante fabricante = new Fabricante();

        try {
            String sql = "SELECT * FROM tienda.fabricante ORDER BY codigo DESC LIMIT 1;";

            consultarDDBB(sql);

            while (rs.next()) {

                fabricante.setCodigo(rs.getInt(1));
                fabricante.setNombre(rs.getString(2));
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return fabricante;
    }

}
