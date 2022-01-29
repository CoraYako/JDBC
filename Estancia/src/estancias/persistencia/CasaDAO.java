package estancias.persistencia;

import estancias.entidades.Casa;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class CasaDAO extends DAO {

    public Casa buscarPorId(Integer idCasa) throws SQLException, Exception {
        Casa casa = null;

        try {
            String sql = "SELECT * FROM casas WHERE id_casa = '"
                    + idCasa + "';";

            consultarDDBB(sql);

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

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return casa;
    }

    public Collection<Casa> listarCasasDisponiblesFechaDesdeYFechaHasta() throws SQLException, Exception {
        Collection<Casa> casas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde = '2020-08-01' AND fecha_hasta = '2020-08-31';";

            consultarDDBB(sql);

            while (rs.next()) {
                Casa casa = new Casa();

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

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return casas;
    }

    public Collection<Casa> listarCasasIndicandoFechaYCantidadDias(Date fecha, Integer dias) throws SQLException, ClassNotFoundException, Exception {
        Collection<Casa> casas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde = ? AND tiempo_maximo <= ?";

            consultaPreparadaDDBB(sql, fecha, dias);

            while (rs.next()) {
                Casa casa = new Casa();

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

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return casas;
    }

    public Collection<Casa> listarTodas() throws Exception {
        Collection<Casa> casas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM casas;";

            consultarDDBB(sql);

            while (rs.next()) {
                Casa casa = new Casa();

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
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return casas;
    }

    public void modificarPrecioHabitacion(Casa casa) throws Exception {
        try {
            String sql = "UPDATE casas SET precio_habitacion = " + casa.getPrecioHabitacion()
                    + "WHERE id_casa = " + casa.getIdCasa() + ";";

            incertarModificarEliminarDDBB(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Map<String, Integer> mostrarCantidadCasasPorPais() throws ClassNotFoundException, SQLException {
        Map<String, Integer> casas = new HashMap<>();

        try {
            String sql = "SELECT COUNT(id_casa), pais FROM casas GROUP BY pais;";

            consultarDDBB(sql);

            while (rs.next()) {
                Integer cant = rs.getInt(1);
                String pais = rs.getString(2);

                casas.put(pais, cant);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return casas;
    }

    public Collection<Casa> listarCasasDeUKLimpias() throws SQLException, ClassNotFoundException {
        Collection<Casa> casasLimpiasUK = new ArrayList<>();

        try {
            String sql = "SELECT * FROM casas cas "
                    + "INNER JOIN comentarios com "
                    + "ON cas.id_casa = com.id_casa "
                    + "WHERE cas.pais LIKE '%Reino Unido%' "
                    + "AND com.comentario LIKE LOWER('%limpia%');";

            consultarDDBB(sql);

            while (rs.next()) {
                Casa c = new Casa();

                c.setIdCasa(rs.getInt(1));
                c.setCalle(rs.getString(2));
                c.setNumero(rs.getInt(3));
                c.setCodigoPostal(rs.getString(4));
                c.setCiudad(rs.getString(5));
                c.setPais(rs.getString(6));
                c.setFechaDesde(rs.getDate(7));
                c.setFechaHasta(rs.getDate(8));
                c.setTiempoMinimo(rs.getInt(9));
                c.setTiempoMaximo(rs.getInt(10));
                c.setPrecioHabitacion(rs.getDouble(11));
                c.setTipoVivienda(rs.getString(12));

                casasLimpiasUK.add(c);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return casasLimpiasUK;
    }
    
    public Collection<Casa> listarCasasDeUK() throws Exception {
        Collection<Casa> casas = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM casas WHERE pais LIKE '%Reino Unido%';";
            
            consultarDDBB(sql);
            
            while (rs.next()) {
                Casa casa = new Casa();

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
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }
        
        return casas;
    }

}
