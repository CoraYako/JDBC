package estancias.servicios;

import estancias.entidades.Familia;
import estancias.persistencia.FamiliaDAO;
import java.util.Collection;

public class FamiliaServicio {

    private final FamiliaDAO familiaDAO;

    public FamiliaServicio() {
        familiaDAO = new FamiliaDAO();
    }

    public Familia buscarPorId(Integer idFamilia) throws Exception {
        if (idFamilia == null || idFamilia < 1) {
            throw new Exception("Debe indicar un idFamilia válido");
        }

        return familiaDAO.buscarPorId(idFamilia);
    }

    public Collection<Familia> listarFamiliasConTresHijos() throws Exception {
        return familiaDAO.listarFamiliasConTresHijos();
    }
    
    public Collection<Familia> listarConCorreoHotmail() throws Exception {
        return familiaDAO.listarConCorreoHotmail();
    }

}
