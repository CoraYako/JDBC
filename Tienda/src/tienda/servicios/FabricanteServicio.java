package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public final class FabricanteServicio {

    private final FabricanteDAO fabricanteDAO;

    public FabricanteServicio() {
        fabricanteDAO = new FabricanteDAO();
    }

    public void crearFabricante(String nombre) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            
            fabricanteDAO.guardarFabricanteDDBB(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {
        try {
            if (codigo == null || codigo < 1) {
                throw new Exception("Debe indicar un código");
            }

            Fabricante fabricante = fabricanteDAO.buscarFabricantePorCodigo(codigo);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Fabricante ultimoFabricanteAgregado() throws Exception {
        try {
            Fabricante fabricante = fabricanteDAO.ultimoFabricanteAgregado();
            
            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

}
