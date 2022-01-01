package tienda.persistencia;

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

    public void guardarProductoEnDDBB(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar un producto");
            }

            String sql = "INSERT INTO tienda.producto (nombre, precio, codigo_fabricante) VALUES ('"
                    + producto.getNombre() + "', '" + producto.getPrecio()
                    + "', '" + producto.getFabricante().getCodigo() + "');";

            insertarModificarEliminarDDBB(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDDBB();
        }
    }

    public Collection<Producto> listarNombreDeProductos() throws Exception {
        try {
            String sql = "SELECT nombre FROM tienda.producto;";

            consultarDDBB(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (rs.next()) {
                producto = new Producto();
                producto.setNombre(rs.getString(1));

                productos.add(producto);
            }

            desconectarDDBB();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDDBB();
            throw new Exception("Ha ocurrido un error");
        }
    }

    public Collection<Producto> listarNombreYPrecioDeProductos() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM tienda.producto;";

            consultarDDBB(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (rs.next()) {
                producto = new Producto();
                producto.setNombre(rs.getString(1));
                producto.setPrecio(rs.getDouble(2));

                productos.add(producto);
            }

            desconectarDDBB();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDDBB();
            throw new Exception("Ha ocurrido un error");
        }
    }

    public Collection<Producto> listarProductosSegunPrecio() throws Exception {
        try {
            String sql = "SELECT * FROM tienda.producto WHERE precio BETWEEN 120 AND 202;";

            consultarDDBB(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (rs.next()) {
                producto = new Producto();
                producto.setCodigo(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));

                Integer codigo_fabricante = rs.getInt(4);
                Fabricante fabricante = fabricanteServicio.buscarFabricantePorCodigo(codigo_fabricante);

                producto.setFabricante(fabricante);

                productos.add(producto);
            }

            desconectarDDBB();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDDBB();
            throw new Exception("Ha ocurrido un error");
        }
    }

    public Collection<Producto> listarPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM tienda.producto WHERE nombre LIKE '%Portatil%';";

            consultarDDBB(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (rs.next()) {
                producto = new Producto();
                producto.setCodigo(rs.getInt("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));

                Integer codigo_fabricante = rs.getInt("codigo_fabricante");
                Fabricante fabricante = fabricanteServicio.buscarFabricantePorCodigo(codigo_fabricante);

                producto.setFabricante(fabricante);

                productos.add(producto);
            }

            desconectarDDBB();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDDBB();
            throw new Exception("Ha ocurrido un error");
        }
    }

    public Producto buscarProductoMasBarato() throws Exception {
        try {
            String sql = "SELECT * FROM tienda.producto WHERE precio = (SELECT MIN(precio) FROM tienda.producto);";

            consultarDDBB(sql);

            Producto producto = null;
            while (rs.next()) {
                producto = new Producto();
                producto.setCodigo(rs.getInt("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));

                Integer codigo_fabricante = rs.getInt("codigo_fabricante");
                Fabricante fabricante = fabricanteServicio.buscarFabricantePorCodigo(codigo_fabricante);

                producto.setFabricante(fabricante);
            }

            desconectarDDBB();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDDBB();
            throw new Exception("Ha ocurrido un error");
        }
    }

    public Producto buscarProductoPorCodigo(Integer codigo) throws Exception {
        try {
            String sql = "SELECT * FROM tienda.producto WHERE codigo = " + codigo + ";";

            consultarDDBB(sql);

            Producto producto = null;
            while (rs.next()) {
                producto = new Producto();

                producto.setCodigo(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));

                Integer codigo_fabricante = rs.getInt(4);
                Fabricante fabricante = fabricanteServicio.buscarFabricantePorCodigo(codigo_fabricante);

                producto.setFabricante(fabricante);
            }

            desconectarDDBB();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDDBB();
            throw new Exception("Ha ocurrido un error");
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar un producto");
            }

            String sql = "UPDATE tienda.producto SET nombre = '" + producto.getNombre()
                    + "', precio = " + producto.getPrecio()
                    + ", codigo_fabricante = " + producto.getFabricante().getCodigo()
                    + " WHERE codigo = " + producto.getCodigo() + ";";

            insertarModificarEliminarDDBB(sql);

        } catch (Exception e) {
            throw e;
        }
    }

}
