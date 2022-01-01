package tienda.persistencia;

import tienda.entidades.Fabricante;

public final class FabricanteDAO extends DAO {

    public void guardarFabricanteDDBB(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar un fabricante");
            }

            String sql = "INCERT INTO tienda.fabricante (nombre) VALUES ('"
                    + fabricante.getNombre() + "');";

            insertarModificarEliminarDDBB(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDDBB();
        }
    }

    public Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {
        try {
            String sql = "SELECT * FROM tienda.fabricante WHERE codigo = '"
                    + codigo + "';";

            consultarDDBB(sql);
            Fabricante fabricante = null;

            while (rs.next()) {
                fabricante = new Fabricante();

                fabricante.setCodigo(rs.getInt(1));
                fabricante.setNombre(rs.getString(2));
            }

            desconectarDDBB();
            return fabricante;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDDBB();
            throw e;
        }
    }

}
