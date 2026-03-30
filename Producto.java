public class Producto {
    int id;              // ID del producto
    String nombre;       // Nombre del producto
    Producto izquierdo;  // Referencia la rama izquierda
    Producto derecho;    // Referencia la rama derecha

    // Constructor: Inicializa el nodo
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }
}