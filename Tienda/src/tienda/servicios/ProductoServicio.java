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

    public void guardarEnDDBB(String nombre, Double precio, Fabricante f) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre");
        }
        if (precio == null) {
            throw new Exception("Debe indicar un precio");
        }
        if (f == null) {
            throw new Exception("Debe indicar un fabricante");
        }

        Producto p = new Producto();

        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setFabricante(f);

        productoDAO.guardarEnDDBB(p);
    }

    public void modificar(Producto p, String nombre, Double precio, Fabricante f) throws Exception {
        if (p == null) {
            throw new Exception("Debe indicar un producto");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre");
        }
        if (precio == null || precio.isNaN()) {
            throw new Exception("Debe indicar un precio");
        }
        if (f == null) {
            throw new Exception("Debe indicar un fabricante");
        }

        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setFabricante(f);

        productoDAO.modificar(p);
    }

    public Collection<Producto> listarNombreYPrecio() throws Exception {
        return productoDAO.listarNombreYPrecio();
    }

    public Collection<Producto> listarNombre() throws Exception {
        return productoDAO.listarNombre();
    }

    public Collection<Producto> listarSegunPrecio() throws Exception {
        return productoDAO.listarSegunPrecio();
    }

    public Collection<Producto> listarPortatiles() throws Exception {
        return productoDAO.listarPortatiles();
    }

    public Producto buscarMasBarato() throws Exception {
        return productoDAO.buscarMasBarato();
    }

    public Producto buscarPorCodigo(Integer codigo) throws Exception {
        if (codigo == null || codigo < 1) {
            throw new Exception("Debe indicar un código");
        }

        return productoDAO.buscarPorCodigo(codigo);
    }

    public Collection<Producto> listarTodos() throws Exception {
        return productoDAO.listarTodos();
    }

}
