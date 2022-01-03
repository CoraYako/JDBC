package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public final class ProductoServicio {

    private final ProductoDAO productoDAO;

    public ProductoServicio() {
        productoDAO = new ProductoDAO();
    }

    public void crearYGuardarProducto(String nombre, Double precio, Fabricante fabricante) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (precio == null) {
                throw new Exception("Debe indicar un precio");
            }
            if (fabricante == null) {
                throw new Exception("Debe indicar un fabricante");
            }

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setFabricante(fabricante);

            productoDAO.guardarProductoEnDDBB(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(Producto producto, String nombre, Double precio, Fabricante fabricante) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar un producto");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (precio == null || precio.isNaN()) {
                throw new Exception("Debe indicar un precio");
            }
            if (fabricante == null) {
                throw new Exception("Debe indicar un fabricante");
            }

            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setFabricante(fabricante);

            productoDAO.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarNombreYPrecioDeProductos() throws Exception {
        try {
            Collection<Producto> productos = productoDAO.listarNombreYPrecioDeProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarNombreDeProductos() throws Exception {
        try {
            Collection<Producto> productos = productoDAO.listarNombreDeProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProductosSegunPrecio() throws Exception {
        try {
            Collection<Producto> productos = productoDAO.listarProductosSegunPrecio();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarPortatiles() throws Exception {
        try {
            Collection<Producto> productos = productoDAO.listarPortatiles();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoMasBarato() throws Exception {
        try {
            Producto producto = productoDAO.buscarProductoMasBarato();

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(Integer codigo) throws Exception {
        try {
            Producto producto = productoDAO.buscarProductoPorCodigo(codigo);

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

}
