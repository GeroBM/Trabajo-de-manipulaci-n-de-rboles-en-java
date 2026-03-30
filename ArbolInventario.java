public class ArbolInventario {
    Producto raiz; // Nodo principal

    public ArbolInventario() {
        this.raiz = null;
    }

    // Se llama a si misma para insertar un nuevo nodo en la posición correcta
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    // Función recursiva que encuentra el lugar correcto para insertar el nuevo nodo
    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        if (actual == null) {
            return new Producto(id, nombre); // Cuando encuentra un espacio vacío, crea un nuevo nodo con los datos
            }

        if (id < actual.id) { // Si el ID es menor, va a la rama izquierda
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } else if (id > actual.id) { // Si el ID es mayor, va a la rama derecha
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        }
        return actual; // Devuelve el nodo actual para mantener la estructura del árbol al final del proceso
    }

    // Muestra en orden los nodos del árbol
    public void mostrarInorden(Producto nodo) {
        if (nodo != null) {
            mostrarInorden(nodo.izquierdo); // Primero visita rama la izquierda
            System.out.println("ID: " + nodo.id + " | Producto: " + nodo.nombre); // Imprime el producto actual
            mostrarInorden(nodo.derecho);   // Luego visita rama la derecha
        }
    }

    // Busca un producto por su ID
    public String buscar(int id) {
        return buscarRecursivo(raiz, id) ? "ID encontrado en el sistema." : "El ID no existe.";
    }

    // La función recursiva que busca el ID
    private boolean buscarRecursivo(Producto actual, int id) {
        if (actual == null) return false; // Si no encontro el ID
        if (id == actual.id) return true; // Si encontro el ID

        // Si el ID es menor, busca en la rama izquierda, sino, en la derecha
        return id < actual.id 
            ? buscarRecursivo(actual.izquierdo, id) 
            : buscarRecursivo(actual.derecho, id);
    }
}