import java.util.Scanner;

// Clase Nodo
class Nodo {
    int dato;
    Nodo izquierdo, derecho;

    public Nodo(int dato) {
        this.dato = dato;
        izquierdo = derecho = null;
    }
}

// Clase Árbol (ANTES era ArbolBinario)
class Arbol {
    Nodo raiz;

    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo insertarRec(Nodo raiz, int dato) {
        if (raiz == null) {
            return new Nodo(dato);
        }

        if (dato < raiz.dato) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, dato);
        } else if (dato > raiz.dato) {
            raiz.derecho = insertarRec(raiz.derecho, dato);
        }

        return raiz;
    }

    // Recorrido Inorden
    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo raiz) {
        if (raiz != null) {
            inordenRec(raiz.izquierdo);
            System.out.print(raiz.dato + " ");
            inordenRec(raiz.derecho);
        }
    }

    // Buscar
    public boolean buscar(int dato) {
        return buscarRec(raiz, dato);
    }

    private boolean buscarRec(Nodo raiz, int dato) {
        if (raiz == null) return false;

        if (dato == raiz.dato) return true;

        if (dato < raiz.dato) {
            return buscarRec(raiz.izquierdo, dato);
        } else {
            return buscarRec(raiz.derecho, dato);
        }
    }
}

// Clase principal
public class ArbolBinario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 👇 CAMBIO AQUÍ
        Arbol arbol = new Arbol();

        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insertar número");
            System.out.println("2. Mostrar inorden");
            System.out.println("3. Buscar número");
            System.out.println("4. Salir");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número: ");
                    int num = sc.nextInt();
                    arbol.insertar(num);
                    break;

                case 2:
                    System.out.println("Recorrido inorden:");
                    arbol.inorden();
                    break;

                case 3:
                    System.out.print("Número a buscar: ");
                    int buscar = sc.nextInt();
                    if (arbol.buscar(buscar)) {
                        System.out.println("El número SI existe");
                    } else {
                        System.out.println("El número NO existe");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 4);

        sc.close();
    }
}