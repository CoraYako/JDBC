package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public final class FabricanteServicio {

    private final FabricanteDAO fabricanteDAO;

    public FabricanteServicio() {
        fabricanteDAO = new FabricanteDAO();
    }

    public void guardarEnDDBB(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre");
        }

        Fabricante f = new Fabricante();
        f.setNombre(nombre);

        fabricanteDAO.guardarEnDDBB(f);
    }

    public Fabricante buscarPorCodigo(Integer codigo) throws Exception {
        if (codigo == null || codigo < 1) {
            throw new Exception("Debe indicar un código");
        }

        return fabricanteDAO.buscarPorCodigo(codigo);
    }

    public Fabricante buscarPorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre");
        }

        return fabricanteDAO.buscarPorNombre(nombre);
    }

    public Fabricante ultimoFabricanteAgregado() throws Exception {
        return fabricanteDAO.ultimoAgregado();
    }
    
    public Collection<Fabricante> listarTodos() throws Exception {
        return fabricanteDAO.listarTodos();
    }

}
