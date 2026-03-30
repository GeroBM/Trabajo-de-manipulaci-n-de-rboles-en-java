import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolInventario miArbol = new ArbolInventario(); // Árbol del inventario
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        String nombre = "";
        int id = 0;
        int idbuscar = 0;

        // Menu
        while (opcion != 0) {
            System.out.println("\n--- INVENTARIO DE PRODUCTOS ---");
            System.out.println("1 Registrar producto");
            System.out.println("2 Ver Inventario");
            System.out.println("3 Buscar Producto");
            System.out.println("0 Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // Insertar nuevo producto
                    System.out.print("Ingrese ID del producto: "); // Pide el ID
                    id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Ingrese el nombre del producto: "); // Pide el nombre
                    nombre = sc.nextLine();
                    miArbol.insertar(id, nombre); // Inserta el producto en el árbol
                    System.out.println("Producto registrado.");
                    break;
                case 2:
                    // Muestra el inventario
                    if (miArbol.raiz != null){
                        System.out.println("\nPRODUCTOS EN EL INVENTARIO:");
                        miArbol.mostrarInorden(miArbol.raiz);
                    }
                    else {
                        System.out.println("El inventario está vacío.");
                    }
                    break;
                case 3:
                    // Busca el producto
                    System.out.print("ID del producto a buscar: ");
                    idbuscar = sc.nextInt();
                    System.out.println(miArbol.buscar(idbuscar));
                    break;
                case 0:
                    // Salir
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}