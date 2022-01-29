package estancias.principal;

import estancias.entidades.Casa;
import estancias.entidades.Estancia;
import estancias.servicios.CasaServicio;
import estancias.servicios.EstanciaServicio;
import estancias.servicios.FamiliaServicio;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EstanciaMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        EstanciaServicio es = new EstanciaServicio();
        CasaServicio cs = new CasaServicio();
        FamiliaServicio fs = new FamiliaServicio();

        Integer opcion, dia, mes, anio;
        String eleccion;

        try {
            do {
                menu();
                opcion = input.nextInt();

                switch (opcion) {
                    case 1:
                        visualizarLista(fs.listarFamiliasConTresHijos());
                        break;
                    case 2:
                        visualizarLista(cs.listarCasasDisponiblesFechaDesdeYFechaHasta());
                        break;
                    case 3:
                        visualizarLista(fs.listarConCorreoHotmail());
                        break;
                    case 4:
                        System.out.println("Ingrese los siguientes datos");
                        System.out.print("Dia: ");
                        dia = input.nextInt();
                        System.out.print("Mes: ");
                        mes = input.nextInt();
                        System.out.print("Año: ");
                        anio = input.nextInt();
                        
                        Date fecha = new Date(anio - 1900, mes - 1, dia);
                        
                        System.out.print("Indique los días de disponibilidad máxima de la casa: ");
                        dia = input.nextInt();
                        
                        visualizarLista(cs.listarCasasIndicandoFechaYCantidadDias(fecha, dia));
                        break;
                    case 5:
                        visualizarLista(es.listarAquellosQueAlquilaronUnaCasa());
                        break;
                    case 6:
                        for (Casa casa : cs.listarCasasDeUK()) {
                            cs.modificarPrecioHabitacion(casa);
                        }
                        System.out.print("Precios modificados ¿Desea ver los nuevos datos? (s/n): ");
                        eleccion = input.next();
                        
                        if (eleccion.equalsIgnoreCase("s")) {
                            visualizarLista(cs.listarCasasDeUK());
                        }
                        break;
                    case 7:
                        for (Map.Entry<String, Integer> aux : cs.mostrarCantidadCasasPorPais().entrySet()) {
                            System.out.println(aux.getKey() + ": " + aux.getValue());
                        }
                        break;
                    case 8:
                        visualizarLista(cs.listarCasasDeUKLimpias());
                        break;
                    case 9:
                        visualizarLista(cs.listarTodas());
                        break;
                    default:
                        System.out.println("Asistente finalizado.");
                }
            } while (opcion != 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void visualizarLista(Collection col) throws Exception {
        if (col.isEmpty()) {
            throw new Exception("La lista está vacía");
        }
        System.out.println("Lista: ");
        
        col.forEach((ob) -> System.out.println(ob + "\n"));
    }

    public static void menu() {
        System.out.println("1. Listar familias que tienen al menos 3 hijos con edad máxima inferior a 10 años.");
        System.out.println("2. Listar las casas disponibles entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.");
        System.out.println("3. Listar familias cuya dirección de mail sea de Hotmail.");
        System.out.println("4. Listar casas disponibles a partir de una fecha y un número de días específico.");
        System.out.println("5. Listar todas las estancias que han sido reservadas por un cliente.");
        System.out.println("6. Incrementar el precio por día en un 5% de todas las casas del Reino Unido");
        System.out.println("7. Obtener el número de casas que existen para cada uno de los países diferentes.");
        System.out.println("8. Listar casas del Reino Unido de las que se han dicho que están limpias.");
        System.out.println("9. Listar todas las casas");
        System.out.println("10. Salir");
        System.out.print("> ");
    }

}
