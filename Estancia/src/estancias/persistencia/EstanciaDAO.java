package estancias.persistencia;

import estancias.entidades.Casa;
import estancias.entidades.Cliente;
import estancias.entidades.Estancia;
import estancias.servicios.CasaServicio;
import estancias.servicios.ClienteServicio;
import java.util.ArrayList;
import java.util.Collection;

public final class EstanciaDAO extends DAO {

    private final ClienteServicio clienteServicio;
    private final CasaServicio casaServicio;

    public EstanciaDAO() {
        clienteServicio = new ClienteServicio();
        casaServicio = new CasaServicio();
    }

    public Estancia buscarPorId(Integer idEstancia) throws Exception {
        Estancia estancia = null;

        try {
            String sql = "SELECT * FROM estancias WHERE id_estancia = " + idEstancia + ";";

            consultarDDBB(sql);

            while (rs.next()) {
                estancia = new Estancia();
                
                estancia.setIdEstancia(rs.getInt(1));

                Integer idcliente = rs.getInt(2);
                Cliente cliente = clienteServicio.buscarPorId(idcliente);
                estancia.setCliente(cliente);

                Integer idCasa = rs.getInt(3);
                Casa casa = casaServicio.buscarPorId(idCasa);
                estancia.setCasa(casa);

                estancia.setNombreHuesped(rs.getString(4));
                estancia.setFechaDesde(rs.getDate(5));
                estancia.setFechaHasta(rs.getDate(6));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return estancia;
    }

    public Collection<Estancia> listarAquellosQueAlquilaronUnaCasa() throws Exception {
        Collection<Estancia> estancias = new ArrayList<>();

        try {
            String sql = "SELECT cli.*, cas.* "
                    + "FROM estancias_exterior.clientes cli "
                    + "INNER JOIN estancias_exterior.estancias est "
                    + "ON cli.id_cliente = est.id_cliente "
                    + "INNER JOIN estancias_exterior.casas cas "
                    + "ON est.id_casa = cas.id_casa;";

            consultarDDBB(sql);

            while (rs.next()) {
                Estancia estancia = new Estancia();

                Integer idCliente = rs.getInt(1);
                Cliente cliente = clienteServicio.buscarPorId(idCliente);

                Integer idCasa = rs.getInt(9);
                Casa casa = casaServicio.buscarPorId(idCasa);

                estancia.setCliente(cliente);
                estancia.setCasa(casa);

                estancias.add(estancia);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return estancias;
    }

}
