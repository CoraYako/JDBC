package tienda.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;

public final class FabricanteDAO extends DAO {

    public void guardarEnDDBB(Fabricante f) throws Exception {
        try {
            String sql = "INSERT INTO tienda.fabricante (nombre) VALUES ('"
                    + f.getNombre() + "');";

            insertarModificarEliminarDDBB(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarPorCodigo(Integer codigo) throws Exception {
        Fabricante f = null;

        try {
            String sql = "SELECT * FROM tienda.fabricante WHERE codigo = "
                    + codigo + ";";

            consultarDDBB(sql);

            while (rs.next()) {
                f = new Fabricante();

                f.setCodigo(rs.getInt(1));
                f.setNombre(rs.getString(2));
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return f;
    }

    public Fabricante buscarPorNombre(String nombre) throws Exception {
        Fabricante f = null;

        try {
            String sql = "SELECT * FROM tienda.fabricante WHERE nombre = '"
                    + nombre + "';";

            consultarDDBB(sql);

            while (rs.next()) {
                f = new Fabricante();

                f.setCodigo(rs.getInt(1));
                f.setNombre(rs.getString(2));
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return f;
    }

    public Fabricante ultimoAgregado() throws Exception {
        Fabricante f = null;

        try {
            String sql = "SELECT * FROM tienda.fabricante ORDER BY codigo DESC LIMIT 1;";

            consultarDDBB(sql);

            while (rs.next()) {
                f = new Fabricante();

                f.setCodigo(rs.getInt(1));
                f.setNombre(rs.getString(2));
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return f;
    }

    public Collection<Fabricante> listarTodos() throws Exception {
        Collection<Fabricante> fabricantes = new ArrayList<>();

        try {
            String sql = "SELECT * FROM fabricante;";

            consultarDDBB(sql);

            while (rs.next()) {
                Fabricante f = new Fabricante();

                f.setCodigo(rs.getInt(1));
                f.setNombre(rs.getString(2));

                fabricantes.add(f);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return fabricantes;
    }

}
