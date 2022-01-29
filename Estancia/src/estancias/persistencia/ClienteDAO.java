package estancias.persistencia;

import estancias.entidades.Cliente;
import java.sql.SQLException;

public final class ClienteDAO extends DAO {

    public Cliente buscarPorId(Integer idCliente) throws Exception {
        Cliente cliente = null;

        try {
            String sql = "SELECT * FROM clientes WHERE id_cliente = " + idCliente + ";";

            consultarDDBB(sql);

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
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDDBB();
        }

        return cliente;
    }

}
