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

    public Collection<Familia> listarFamiliasConTresHijos() throws SQLException, Exception {
        try {
            String sql = "SELECT * FROM familias WHERE num_hijos = 3 AND edad_maxima < 10;";

            consultarDDBB(sql);

            Familia familia = null;
            Collection<Familia> familias = new ArrayList<>();

            while (rs.next()) {
                familia = new Familia();

                familia.setIdFamilia(rs.getInt(1));
                familia.setNombre(rs.getString(2));
                familia.setEdadMinima(rs.getInt(3));
                familia.setEdadMaxima(rs.getInt(4));
                familia.setNumHijos(rs.getInt(5));
                familia.setEmail(rs.getString(6));

                Integer idCasa = rs.getInt(7);
                Casa casa = casaServicio.buscarCasaPorId(idCasa);

                familia.setCasa(casa);

                familias.add(familia);
            }

            desconectarDDBB();
            return familias;
        } catch (Exception e) {
            desconectarDDBB();
            e.printStackTrace();
            throw new Exception("Ha ocurrido un error");
        }
    }
    
    public Collection<Familia> listarFamiliasConHotmail() throws SQLException, Exception {
        try {
            String sql = "SELECT * FROM familias WHERE email LIKE '%hotmail%';";
            
            consultarDDBB(sql);
            
            Collection<Familia> familias = new ArrayList<>();
            Familia familia = null;
            
            while (rs.next()) {                
                familia = new Familia();
                
                familia.setIdFamilia(rs.getInt(1));
                familia.setNombre(rs.getString(2));
                familia.setEdadMinima(rs.getInt(3));
                familia.setEdadMaxima(rs.getInt(4));
                familia.setNumHijos(rs.getInt(5));
                familia.setEmail(rs.getString(6));
                
                Integer idCasa = rs.getInt(7);
                Casa casa = casaServicio.buscarCasaPorId(idCasa);
                
                familia.setCasa(casa);
                
                familias.add(familia);
            }
            
            desconectarDDBB();
            return familias;
        } catch (Exception e) {
            desconectarDDBB();
            e.printStackTrace();
            throw new Exception("Ha ocurrido un error");
        }
    }

}
