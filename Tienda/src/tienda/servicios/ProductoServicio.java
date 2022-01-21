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
    }

    public void modificarProducto(Producto producto, String nombre, Double precio, Fabricante fabricante) throws Exception {
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
    }

    public Collection<Producto> listarNombreYPrecioDeProductos() throws Exception {
        Collection<Producto> productos = productoDAO.listarNombreYPrecioDeProductos();

        return productos;
    }

    public Collection<Producto> listarNombreDeProductos() throws Exception {
        Collection<Producto> productos = productoDAO.listarNombreDeProductos();

        return productos;
    }

    public Collection<Producto> listarProductosSegunPrecio() throws Exception {
        Collection<Producto> productos = productoDAO.listarProductosSegunPrecio();

        return productos;
    }

    public Collection<Producto> listarPortatiles() throws Exception {
        Collection<Producto> productos = productoDAO.listarPortatiles();

        return productos;
    }

    public Producto buscarProductoMasBarato() throws Exception {
        Producto producto = productoDAO.buscarProductoMasBarato();

        return producto;
    }

    public Producto buscarProductoPorCodigo(Integer codigo) throws Exception {
        Producto producto = productoDAO.buscarProductoPorCodigo(codigo);

        return producto;
    }

}
