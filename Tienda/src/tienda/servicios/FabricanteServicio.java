package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public final class FabricanteServicio {

    private final FabricanteDAO fabricanteDAO;

    public FabricanteServicio() {
        fabricanteDAO = new FabricanteDAO();
    }

    public void crearYGuardarFabricanteDDBB(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre");
        }

        Fabricante fabricante = new Fabricante();
        fabricante.setNombre(nombre);

        fabricanteDAO.guardarFabricanteDDBB(fabricante);
    }

    public Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {
        if (codigo == null || codigo < 1) {
            throw new Exception("Debe indicar un código");
        }

        Fabricante fabricante = fabricanteDAO.buscarFabricantePorCodigo(codigo);

        return fabricante;
    }

    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre");
        }

        Fabricante fabricante = fabricanteDAO.buscarFabricantePorNombre(nombre);

        return fabricante;
    }

    public Fabricante ultimoFabricanteAgregado() throws Exception {
        Fabricante fabricante = fabricanteDAO.ultimoFabricanteAgregado();

        return fabricante;
    }

}
