package PaqB05;

/**
 * Clase que define un puerto con hubs de contenedores.
 * @see Hub
 */
public class Puerto {
    private Hub[] hubs;


    /**
     * Constructor de la clase Puerto. Crea un puerto con 3 hubs de contenedores.
     */
    public Puerto() {
        this.hubs = new Hub[3];
        for (int i = 0; i < this.hubs.length; i++) {
            this.hubs[i] = new Hub();
        }
    }


    /**
     *
     */
    public Hub getHub(int n) {
        return this.hubs[n];
    }


    public int buscarPorPais(String pais) {
        int total = 0;

        for (int i = 0; i < this.hubs.length; i++) {
            total += this.hubs[i].calcularContenedoresPorPais(pais);
        }

        return total;
    }

    /**
     * Intenta apilar el contenedor en el primer Hub que encuentre con espacio disponible.
     *
     * @param contenedor contenedor a apilar.
     * @return entero indicando el hub en el que se ha apilado o -1 si no se ha podido apilar.
     */
    public boolean insertarEnHub(Contenedor contenedor, int numHub) {
        return this.hubs[numHub-1].apilarContenedor(contenedor);
    }

    public boolean desapilar(int columna, int hub) {
        if (hub >= 1 && hub <= 3) {
            return this.hubs[hub-1].desapilarContenedor(columna-1);
        }

        return false;
    }


    public Contenedor buscarContenedor(int id, int numHub) {
        return this.hubs[numHub-1].mostrarDatos(id);
    }
}
