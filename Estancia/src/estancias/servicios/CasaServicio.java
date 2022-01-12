package estancias.servicios;

import estancias.entidades.Casa;
import estancias.persistencia.CasaDAO;
import java.sql.Date;
import java.util.Collection;

public final class CasaServicio {

    private final CasaDAO casaDAO;

    public CasaServicio() {
        casaDAO = new CasaDAO();
    }

    public Casa buscarCasaPorId(Integer idCasa) throws Exception {
        try {
            if (idCasa == null || idCasa < 1) {
                throw new Exception("Debe indicar un idCasa");
            }

            Casa casa = casaDAO.buscarCasaPorId(idCasa);

            return casa;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Casa> listarCasasIndicandoFechaYCantidadDias(Date fecha, Integer dias) throws Exception {
        try {
            if (fecha == null) {
                throw new Exception("Debe indicar una fecha");
            }
            if (dias == null || dias < 1) {
                throw new Exception("Debe indicar la cantidad de días");
            }

            Collection<Casa> casas = casaDAO.listarCasasIndicandoFechaYCantidadDias(fecha, dias);

            return casas;
        } catch (Exception e) {
            throw e;
        }
    }

}
