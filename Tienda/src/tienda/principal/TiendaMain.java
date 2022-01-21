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

        Integer opcion;

        do {
            menu();
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        visualizarColeccion(productoServicio.listarNombreDeProductos());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Se ha producido el siguiente error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        visualizarColeccion(productoServicio.listarNombreYPrecioDeProductos());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Se ha producido el siguiente error: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        visualizarColeccion(productoServicio.listarProductosSegunPrecio());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Se ha producido el siguiente error: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        visualizarColeccion(productoServicio.listarPortatiles());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Se ha producido el siguiente error: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        Producto producto = productoServicio.buscarProductoMasBarato();
                        System.out.println(producto.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Se ha producido el siguiente error: " + e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        System.out.print("Indique nombre del producto: ");
                        String nombre = input.next();
                        System.out.print("Precio: ");
                        Double precio = input.nextDouble();
                        System.out.print("Nombre del fabricante: ");
                        String nombreFabricante = input.next();

                        fabricanteServicio.crearYGuardarFabricanteDDBB(nombreFabricante);

                        Fabricante fabricante = fabricanteServicio.ultimoFabricanteAgregado();

                        productoServicio.crearYGuardarProducto(nombre, precio, fabricante);

                        System.out.println("Nuevo producto ingresado a la DDBB");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Se ha producido el siguiente error: " + e.getMessage());
                    }
                    break;

                case 7:
                    try {
                        System.out.print("Indique un nombre para el fabricante: ");
                        String nombre = input.next();

                        fabricanteServicio.crearYGuardarFabricanteDDBB(nombre);

                        System.out.println("Nuevo fabricante ingresado a la DDBB");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Se ha producido el siguiente error: " + e.getMessage());
                    }
                    break;

                case 8:
                    try {
                        System.out.print("Por favor, ingrese el código del producto a modificar: ");
                        Integer codigo = input.nextInt();
                        Producto producto = productoServicio.buscarProductoPorCodigo(codigo);

                        System.out.println("A continuación indique los nuevos datos");
                        System.out.print("Nombre: ");
                        String nombre = input.next();
                        System.out.print("Precio: ");
                        Double precio = input.nextDouble();

                        System.out.print("Nombre del fabricante: ");
                        String nombreFabricante = input.next();
                        Fabricante fabricante = fabricanteServicio.buscarFabricantePorNombre(nombreFabricante);

                        productoServicio.modificarProducto(producto, nombre, precio, fabricante);

                        System.out.println("El producto indicado ha sido modificado");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Se ha producido el siguiente error: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Asistente finalizado");
            }
        } while (!opcion.equals(9));

    }

    public static void menu() {
        System.out.println("=== Asistente Virtual de Gestionamiento ===");
        System.out.println("1. Lista nombre de los productos");
        System.out.println("2. Lista nombres y precios de productos");
        System.out.println("3. Listar los productos que su precio esté entre 120 y 202.");
        System.out.println("4. Buscar y listar todos los Portátiles de la tabla producto.");
        System.out.println("5. Listar nombre y precio del producto más barato.");
        System.out.println("6. Ingresar un producto a la base de datos.");
        System.out.println("7. Ingresar un fabricante a la base de datos");
        System.out.println("8. Editar los datos de un producto");
        System.out.println("9. Salir");
        System.out.print("> ");
    }

    public static void visualizarColeccion(Collection col) {
        col.forEach((ob) -> System.out.println(ob + "\n"));
    }

}
