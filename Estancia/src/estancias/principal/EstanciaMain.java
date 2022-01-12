package estancias.principal;

import estancias.entidades.Casa;
import estancias.entidades.Familia;
import estancias.servicios.CasaServicio;
import estancias.servicios.FamiliaServicio;
import java.sql.Date;
import java.util.Collection;

public class EstanciaMain {

    public static void main(String[] args) {

        CasaServicio casaServicio = new CasaServicio();

        try {
            Date fecha = new Date(2020-1900, 06-1, 01);
            Integer dias = 30;
            
            System.out.println(fecha);
            
            Collection<Casa> casas = casaServicio.listarCasasIndicandoFechaYCantidadDias(fecha, dias);

            visualizarLista(casas);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void visualizarLista(Collection col) {
        col.forEach((ob) -> System.out.println(ob + "\n"));
    }

}
