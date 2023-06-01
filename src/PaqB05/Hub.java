package PaqB05;

/**
 * Clase que define un hub de contenedores marítimos. Cada hub almacena hasta un total de 120 contenedores,
 * apilados en 10 filas y 12 columnas.</br></br>
 * La primera columna está destinada a contenedores con prioridad 1, la segunda columna a contenedores con
 * prioridad 2, y el resto de columnas, a los contenedores con prioridad 3.
 *
 * @see Contenedor
 */
public class Hub {
    private Contenedor[][] contenedores;    // debe inicializarse con 10 filas y 12 columnas.
    private static int numContenedor = 1;           // utilizado para asignar un identificador (único en el
                                                    // puerto) a cada contenedor antes de apilarlos.


    /**
     * Constructor de la clase Hub. Construye un hub con capacidad para 10 filas y 12 columnas de
     * contenedores.
     */
    public Hub() {
        this.contenedores = new Contenedor[10][12];
    }


    /**
     * Asignar a este Hub los contenedores del Hub indicado.
     *
     * @param contenedores el hub a asignar a este hub.
     */
    public void setContenedores(Contenedor[][] contenedores) {
        this.contenedores = contenedores;
    }


    /**
     * Devuelve este Hub de contenedores.
     *
     * @return el hub de contenedores.
     */
    public Contenedor[][] getContenedores() {

        return contenedores;

    }


    public static int getNumContenedor() { return Hub.numContenedor; }


    /**
     * Busca en este Hub un contenedor con el número de identificador dado, y si lo encuentra, devuelve una
     * cadena con la información del mismo. En caso de no encontrarlo, indica con otra cadena que no ha podido
     * encontrarlo.
     *
     * @param identificador identificador del contenedor a buscar.
     * @return cadena con la información del contenedor.
     */
    public Contenedor mostrarDatos(int identificador) {
        Contenedor encontrado = null;

        for (int i = 0; i < this.contenedores.length; i++) {
            for (int j = 0; j < this.contenedores[0].length; j++) {
                if (this.contenedores[i][j] != null && this.contenedores[i][j].getIdentificador() == identificador) {
                    encontrado = contenedores[i][j];
                }
            }
        }

        return encontrado;
    }


    /**
     * Apilar un contenedor en función de su prioridad. Si la prioridad es 1, se intenta almacenar en la
     * primera columna; si la prioridad es 2, en la segunda columna; y si la prioridad es 3, en cualquiera de
     * las otras 10 columnas.
     *
     * @param cont contenedor a apilar
     */
    public boolean apilarContenedor(Contenedor cont) {
        if (cont != null) {
            cont.setIdentificador(Hub.numContenedor);
            Hub.numContenedor++;

            switch (cont.getPrioridad()) {
                case 1:
                case 2:
                    int col = cont.getPrioridad() - 1;

                    for (int i = this.contenedores.length - 1; i >= 0; i--) {
                        if (this.contenedores[i][col] == null) {
                            this.contenedores[i][col] = cont;
                            return true;
                        }
                    }

                    break;

                case 3:
                    for (int j = 2; j < this.contenedores[0].length; j++) {
                        for (int i = this.contenedores.length - 1; i >= 0; i--) {
                            if (this.contenedores[i][j] == null) {
                                this.contenedores[i][j] = cont;
                                return true;
                            }
                        }
                    }

                    break;
            }
        }

        return false;
    }


    /**
     * Desapilar el primer contenedor encontrado en la columna indicada de este Hub. Si la columna no se
     * encuentra en el rango válido, devuelve null en lugar del contenedor.
     *
     * @param columna número de columna de la que desapilar un contenedor.
     */
    public boolean desapilarContenedor(int columna) {
        boolean desapilado = false;

        if (columna >= 0 && columna < this.contenedores[0].length) {
            for (int i = 0; i < this.contenedores.length && !desapilado; i++) {
                if (this.contenedores[i][columna] != null) {
                    this.contenedores[i][columna] = null;
                    desapilado = true;
                }
            }
        }

        return desapilado;
    }


    public int Prioritarios(int prioridad){

        int contador = 0;

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 12; j++) {

                if(contenedores[i][j].getPrioridad() == prioridad){

                    contador++;

                }

            }

        }

        return contador;

    }



    /**
     * Calcula el número total de contenedores que proceden de un país determinado.
     *
     * @param procedencia país de procedencia.
     * @return número total de contenedores procedentes del país.
     */
    public int calcularContenedoresPorPais(String procedencia) {
        int cont = 0;

        for (int i = 0; i < this.contenedores.length; i++) {
            for (int j = 0; j < this.contenedores[i].length; j++) {
                if (this.contenedores[i][j] != null && procedencia.equals(this.contenedores[i][j].getProcedencia())) {
                    cont++;
                }
            }
        }
        return cont;

    }


    /**
     * Devuelve un plano del Hub indicando una "X" en las posiciones ocupadas por algún contenedor.
     *
     * @return plano del Hub
     */
    public String toString() {
        StringBuffer s = new StringBuffer();

        for (int i = 0; i < this.contenedores.length; i++) {
            for (int j = 0; j < this.contenedores[i].length; j++) {
                if (this.contenedores[i][j] != null) {
                    s.append("   O   ");
                } else {
                    s.append("   L   ");
                }
            }
            s.append("\n");
        }

        return s.toString();
    }
}
