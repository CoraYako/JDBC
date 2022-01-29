package tienda.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.servicios.FabricanteServicio;

public final class ProductoDAO extends DAO {

    private final FabricanteServicio fabricanteServicio;

    public ProductoDAO() {
        fabricanteServicio = new FabricanteServicio();
    }

    public void guardarEnDDBB(Producto p) throws Exception {
        try {
            String sql = "INSERT INTO tienda.producto (nombre, precio, codigo_fabricante) VALUES ('"
                    + p.getNombre() + "', '" + p.getPrecio()
                    + "', '" + p.getFabricante().getCodigo() + "');";

            insertarModificarEliminarDDBB(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarNombre() throws Exception {
        Collection<Producto> productos = new ArrayList<>();

        try {
            String sql = "SELECT nombre FROM tienda.producto;";

            consultarDDBB(sql);

            while (rs.next()) {
                Producto p = new Producto();
                p.setNombre(rs.getString(1));

                productos.add(p);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return productos;
    }

    public Collection<Producto> listarNombreYPrecio() throws Exception {
        Collection<Producto> productos = new ArrayList<>();

        try {
            String sql = "SELECT nombre, precio FROM tienda.producto;";

            consultarDDBB(sql);

            while (rs.next()) {
                Producto p = new Producto();
                p.setNombre(rs.getString(1));
                p.setPrecio(rs.getDouble(2));

                productos.add(p);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return productos;
    }

    public Collection<Producto> listarSegunPrecio() throws Exception {
        Collection<Producto> productos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tienda.producto WHERE precio BETWEEN 120 AND 202;";

            consultarDDBB(sql);

            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigo(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));

                Integer codigo_fabricante = rs.getInt(4);
                Fabricante f = fabricanteServicio.buscarPorCodigo(codigo_fabricante);

                p.setFabricante(f);

                productos.add(p);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return productos;
    }

    public Collection<Producto> listarPortatiles() throws Exception {
        Collection<Producto> productos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tienda.producto WHERE nombre LIKE '%Portatil%';";

            consultarDDBB(sql);

            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigo(rs.getInt("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));

                Integer codigo_fabricante = rs.getInt("codigo_fabricante");
                Fabricante f = fabricanteServicio.buscarPorCodigo(codigo_fabricante);

                p.setFabricante(f);

                productos.add(p);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return productos;
    }

    public Producto buscarMasBarato() throws Exception {
        Producto p = null;

        try {
            String sql = "SELECT * FROM tienda.producto WHERE precio = (SELECT MIN(precio) FROM tienda.producto);";

            consultarDDBB(sql);

            while (rs.next()) {
                p = new Producto();
                p.setCodigo(rs.getInt("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));

                Integer codigo_fabricante = rs.getInt("codigo_fabricante");
                Fabricante f = fabricanteServicio.buscarPorCodigo(codigo_fabricante);

                p.setFabricante(f);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return p;
    }

    public Producto buscarPorCodigo(Integer codigo) throws Exception {
        Producto p = null;

        try {
            String sql = "SELECT * FROM tienda.producto WHERE codigo = " + codigo + ";";

            consultarDDBB(sql);

            while (rs.next()) {
                p = new Producto();

                p.setCodigo(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));

                Integer codigo_fabricante = rs.getInt(4);
                Fabricante f = fabricanteServicio.buscarPorCodigo(codigo_fabricante);

                p.setFabricante(f);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return p;
    }

    public void modificar(Producto p) throws Exception {
        try {
            String sql = "UPDATE tienda.producto SET nombre = '" + p.getNombre()
                    + "', precio = " + p.getPrecio()
                    + ", codigo_fabricante = " + p.getFabricante().getCodigo()
                    + " WHERE codigo = " + p.getCodigo() + ";";

            insertarModificarEliminarDDBB(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarTodos() throws Exception {
        Collection<Producto> productos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM producto;";

            consultarDDBB(sql);

            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigo(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));

                Integer codigo_fabricante = rs.getInt(4);
                Fabricante f = fabricanteServicio.buscarPorCodigo(codigo_fabricante);

                p.setFabricante(f);

                productos.add(p);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return productos;
    }

}
