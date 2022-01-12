package estancias.persistencia;

import estancias.entidades.Cliente;
import java.util.ArrayList;
import java.util.Collection;

public final class ClienteDAO extends DAO {

    public Collection<Cliente> listarClientesQueAlquilaron() throws Exception {
        try {
            String sql = "SELECT cl.*, ca.* "
                    + "FROM estancias_exterior.clientes cl "
                    + "INNER JOIN estancias_exterior.estancias est "
                    + "ON cl.id_cliente = est.id_cliente "
                    + "INNER JOIN estancias_exterior.casas ca "
                    + "ON est.id_casa = ca.id_casa;";
            consultarDDBB(sql);

            Cliente cliente = null;
            Collection<Cliente> clientes = new ArrayList<>();

            while (rs.next()) {
                cliente = new Cliente();

                cliente.setIdCliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setCalle(rs.getString(3));
                cliente.setNumero(rs.getInt(4));
                cliente.setCodigoPostal(rs.getString(5));
                cliente.setCiudad(rs.getString(6));
                cliente.setPais(rs.getString(7));
                cliente.setEmail(rs.getString(8));

                clientes.add(cliente);
            }

            desconectarDDBB();
            return clientes;
        } catch (Exception e) {
            desconectarDDBB();
            e.printStackTrace();
            throw new Exception("Ha ocurrido un error");
        }
    }

}
