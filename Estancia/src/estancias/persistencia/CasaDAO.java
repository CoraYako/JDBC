package estancias.persistencia;

import estancias.entidades.Casa;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public final class CasaDAO extends DAO {

    public Casa buscarCasaPorId(Integer idCasa) throws SQLException, Exception {
        try {
            String sql = "SELECT * FROM casas WHERE id_casa = '"
                    + idCasa + "';";

            consultarDDBB(sql);

            Casa casa = null;

            while (rs.next()) {
                casa = new Casa();

                casa.setIdCasa(rs.getInt(1));
                casa.setCalle(rs.getString(2));
                casa.setNumero(rs.getInt(3));
                casa.setCodigoPostal(rs.getString(4));
                casa.setCiudad(rs.getString(5));
                casa.setPais(rs.getString(6));
                casa.setFechaDesde(rs.getDate(7));
                casa.setFechaHasta(rs.getDate(8));
                casa.setTiempoMaximo(rs.getInt(9));
                casa.setTiempoMinimo(rs.getInt(10));
                casa.setPrecioHabitacion(rs.getDouble(11));
                casa.setTipoVivienda(rs.getString(12));
            }

            desconectarDDBB();
            return casa;
        } catch (ClassNotFoundException | SQLException e) {
            desconectarDDBB();
            e.printStackTrace();
            throw new Exception("Ha ocurrido un error");
        }
    }

    public Collection<Casa> listarCasasDisponiblesFechaDesdeYFechaHasta() throws SQLException, Exception {
        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde = '2020-08-01' AND fecha_hasta = '2020-08-31';";

            consultarDDBB(sql);

            Casa casa = null;
            Collection<Casa> casas = new ArrayList<>();

            while (rs.next()) {
                casa = new Casa();

                casa.setIdCasa(rs.getInt(1));
                casa.setCalle(rs.getString(2));
                casa.setNumero(rs.getInt(3));
                casa.setCodigoPostal(rs.getString(4));
                casa.setCiudad(rs.getString(5));
                casa.setPais(rs.getString(6));
                casa.setFechaDesde(rs.getDate(7));
                casa.setFechaHasta(rs.getDate(8));
                casa.setTiempoMinimo(rs.getInt(9));
                casa.setTiempoMaximo(rs.getInt(10));
                casa.setPrecioHabitacion(rs.getDouble(11));
                casa.setTipoVivienda(rs.getString(12));

                casas.add(casa);
            }

            desconectarDDBB();
            return casas;
        } catch (ClassNotFoundException | SQLException e) {
            desconectarDDBB();
            e.printStackTrace();
            throw new Exception("Ha ocurrido un error");
        }
    }

    public Collection<Casa> listarCasasIndicandoFechaYCantidadDias(Date fecha, Integer dias) throws SQLException, ClassNotFoundException, Exception {
        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde = ? AND tiempo_maximo <= ?";

            consultaPreparadaDDBB(sql, fecha, dias);

            Casa casa = null;
            Collection<Casa> casas = new ArrayList<>();

            while (rs.next()) {
                casa = new Casa();

                casa.setIdCasa(rs.getInt(1));
                casa.setCalle(rs.getString(2));
                casa.setNumero(rs.getInt(3));
                casa.setCodigoPostal(rs.getString(4));
                casa.setCiudad(rs.getString(5));
                casa.setPais(rs.getString(6));
                casa.setFechaDesde(rs.getDate(7));
                casa.setFechaHasta(rs.getDate(8));
                casa.setTiempoMinimo(rs.getInt(9));
                casa.setTiempoMaximo(rs.getInt(10));
                casa.setPrecioHabitacion(rs.getDouble(11));
                casa.setTipoVivienda(rs.getString(12));

                casas.add(casa);
            }

            desconectarDDBB();
            return casas;
        } catch (ClassNotFoundException | SQLException e) {
            desconectarDDBB();
            e.printStackTrace();
            throw new Exception("Ha ocurrido un error");
        }
    }

}
