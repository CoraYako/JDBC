package estancias.servicios;

import estancias.entidades.Familia;
import estancias.persistencia.FamiliaDAO;
import java.util.Collection;

public class FamiliaServicio {
    
    private final FamiliaDAO familiaDAO;
    
    public FamiliaServicio() {
        familiaDAO = new FamiliaDAO();
    }

    public Collection<Familia> listarFamiliasConTresHijos() throws Exception {
        try {
            Collection<Familia> familias = familiaDAO.listarFamiliasConTresHijos();
            
            return familias;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
