package estancias.servicios;

import estancias.entidades.Casa;
import estancias.persistencia.CasaDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public final class CasaServicio {

    private final CasaDAO casaDAO;

    public CasaServicio() {
        casaDAO = new CasaDAO();
    }

    public Casa buscarPorId(Integer idCasa) throws Exception {
        if (idCasa == null || idCasa < 1) {
            throw new Exception("Debe indicar un idCasa");
        }

        return casaDAO.buscarPorId(idCasa);
    }

    public Collection<Casa> listarCasasIndicandoFechaYCantidadDias(Date fecha, Integer dias) throws Exception {
        if (fecha == null) {
            throw new Exception("Debe indicar una fecha");
        }
        if (dias == null || dias < 1) {
            throw new Exception("Debe indicar la cantidad de días");
        }

        return casaDAO.listarCasasIndicandoFechaYCantidadDias(fecha, dias);
    }

    public Collection<Casa> listarTodas() throws Exception {
        return casaDAO.listarTodas();
    }

    public void modificarPrecioHabitacion(Casa casa) throws Exception {
        if (casa == null) {
            throw new Exception("Debe indicar una casa");
        }

        Double aumento = casa.getPrecioHabitacion() * 1.05;
        Double precioActual = casa.getPrecioHabitacion();

        casa.setPrecioHabitacion(precioActual + aumento);

        casaDAO.modificarPrecioHabitacion(casa);
    }

    public Collection<Casa> listarCasasDeUKLimpias() throws SQLException, ClassNotFoundException {
        return casaDAO.listarCasasDeUKLimpias();
    }

    public Map<String, Integer> mostrarCantidadCasasPorPais() throws SQLException, ClassNotFoundException {
        return casaDAO.mostrarCantidadCasasPorPais();
    }
    
    public Collection<Casa> listarCasasDeUK() throws Exception {
        return casaDAO.listarCasasDeUK();
    }
    
    public Collection<Casa> listarCasasDisponiblesFechaDesdeYFechaHasta() throws Exception {
        return casaDAO.listarCasasDisponiblesFechaDesdeYFechaHasta();
    }

}
