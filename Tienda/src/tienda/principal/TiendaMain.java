package tienda.principal;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;

public class TiendaMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in).useDelimiter("\n");

        FabricanteServicio fabricanteServicio = new FabricanteServicio();
        ProductoServicio productoServicio = new ProductoServicio();

        Integer opcion, codigo;
        String nombre, nombreFabricante, eleccion;
        Double precio;
        Fabricante f = null;
        Producto p = null;

        try {
            do {
                menu();
                opcion = input.nextInt();
                switch (opcion) {
                    case 1:
                        visualizarColeccion(productoServicio.listarNombre());
                        break;
                    case 2:
                        visualizarColeccion(productoServicio.listarNombreYPrecio());
                        break;
                    case 3:
                        visualizarColeccion(productoServicio.listarSegunPrecio());
                        break;
                    case 4:
                        visualizarColeccion(productoServicio.listarPortatiles());
                        break;
                    case 5:
                        System.out.println(productoServicio.buscarMasBarato().toString());
                        break;
                    case 6:
                        System.out.print("Indique nombre del producto: ");
                        nombre = input.next();
                        System.out.print("Precio: ");
                        precio = input.nextDouble();

                        System.out.println("¿El nuevo producto es de un fabricante existente? (s/n)");
                        eleccion = input.next();

                        if (eleccion.equalsIgnoreCase("s")) {
                            visualizarColeccion(fabricanteServicio.listarTodos());

                            System.out.print("Indique el código del fabricante: ");
                            codigo = input.nextInt();

                            f = fabricanteServicio.buscarPorCodigo(codigo);
                        } else {
                            System.out.print("Nombre del fabricante: ");
                            nombreFabricante = input.next();

                            fabricanteServicio.guardarEnDDBB(nombreFabricante);

                            f = fabricanteServicio.ultimoFabricanteAgregado();
                        }

                        productoServicio.guardarEnDDBB(nombre, precio, f);

                        System.out.println("Nuevo producto ingresado a la DDBB");

                        break;
                    case 7:
                        System.out.print("Indique un nombre para el fabricante: ");
                        nombre = input.next();

                        fabricanteServicio.guardarEnDDBB(nombre);

                        System.out.println("Nuevo fabricante ingresado a la DDBB");

                        break;
                    case 8:
                        visualizarColeccion(productoServicio.listarTodos());
                        System.out.print("Por favor, ingrese el código del producto a modificar: ");
                        codigo = input.nextInt();
                        p = productoServicio.buscarPorCodigo(codigo);

                        System.out.println("A continuación indique los nuevos datos");
                        System.out.print("Nombre: ");
                        nombre = input.next();
                        System.out.print("Precio: ");
                        precio = input.nextDouble();

                        System.out.print("Código del fabricante: ");
                        codigo = input.nextInt();
                        f = fabricanteServicio.buscarPorCodigo(codigo);

                        productoServicio.modificar(p, nombre, precio, f);

                        System.out.println("El producto indicado ha sido modificado");

                        break;
                    default:
                        System.out.println("Asistente finalizado");
                }
            } while (!opcion.equals(9));
        } catch (Exception e) {
            System.out.println("Se produjo el siguiente error: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void menu() {
        System.out.println("=== Asistente Virtual de Gestionamiento ===");
        System.out.println("1. Lista nombre de los productos");
        System.out.println("2. Lista nombres y precios de productos");
        System.out.println("3. Listar los productos que su precio esté entre 120 y 202.");
        System.out.println("4. Buscar y listar todos los Portátiles de la tabla producto.");
        System.out.println("5. Listar nombre y precio del producto más barato.");
        System.out.println("6. Ingresar un nuevo producto a la base de datos.");
        System.out.println("7. Ingresar un fabricante a la base de datos");
        System.out.println("8. Editar los datos de un producto");
        System.out.println("9. Salir");
        System.out.print("> ");
    }

    public static void visualizarColeccion(Collection col) throws Exception {
        if (col.isEmpty()) {
            throw new Exception("La lista está vacía");
        }

        System.out.println("Lista: ");
        col.forEach((ob) -> System.out.println(ob + "\n"));
    }

}
