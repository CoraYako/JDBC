package estancias.persistencia;

import estancias.entidades.Casa;
import estancias.entidades.Familia;
import estancias.servicios.CasaServicio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public final class FamiliaDAO extends DAO {

    private final CasaServicio casaServicio;

    public FamiliaDAO() {
        casaServicio = new CasaServicio();
    }

    public Familia buscarPorId(Integer idFamilia) throws Exception {
        Familia familia = null;

        try {
            String sql = "SELECT * FROM familias WHERE id_familia = " + idFamilia + ";";

            consultarDDBB(sql);

            while (rs.next()) {
                familia = new Familia();

                familia.setIdFamilia(rs.getInt(1));
                familia.setNombre(rs.getString(2));
                familia.setEdadMinima(rs.getInt(3));
                familia.setEdadMaxima(rs.getInt(4));
                familia.setNumHijos(rs.getInt(5));
                familia.setEmail(rs.getString(6));

                Integer idCasa = rs.getInt(7);
                Casa casa = casaServicio.buscarPorId(idCasa);

                familia.setCasa(casa);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return familia;
    }

    public Collection<Familia> listarFamiliasConTresHijos() throws SQLException, Exception {
        Collection<Familia> familias = new ArrayList<>();

        try {
            String sql = "SELECT * FROM familias WHERE num_hijos = 3 AND edad_maxima < 10;";

            consultarDDBB(sql);

            while (rs.next()) {
                Familia familia = new Familia();

                familia.setIdFamilia(rs.getInt(1));
                familia.setNombre(rs.getString(2));
                familia.setEdadMinima(rs.getInt(3));
                familia.setEdadMaxima(rs.getInt(4));
                familia.setNumHijos(rs.getInt(5));
                familia.setEmail(rs.getString(6));

                Integer idCasa = rs.getInt(7);
                Casa casa = casaServicio.buscarPorId(idCasa);

                familia.setCasa(casa);

                familias.add(familia);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return familias;
    }

    public Collection<Familia> listarConCorreoHotmail() throws SQLException, Exception {
        Collection<Familia> familias = new ArrayList<>();

        try {
            String sql = "SELECT * FROM familias WHERE email LIKE '%hotmail%';";

            consultarDDBB(sql);

            while (rs.next()) {
                Familia familia = new Familia();

                familia.setIdFamilia(rs.getInt(1));
                familia.setNombre(rs.getString(2));
                familia.setEdadMinima(rs.getInt(3));
                familia.setEdadMaxima(rs.getInt(4));
                familia.setNumHijos(rs.getInt(5));
                familia.setEmail(rs.getString(6));

                Integer idCasa = rs.getInt(7);
                Casa casa = casaServicio.buscarPorId(idCasa);

                familia.setCasa(casa);

                familias.add(familia);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return familias;
    }

}
