package PaqB05;

/**
 * Clase que define un contenedor marítimo. La información relativa a un contenedor viene dada por:</br><ul>
 * <li>Número de identificación.</li>
 * <li>Peso.</li>
 * <li>País de procedencia.</li>
 * <li>Si se ha inspeccionado en aduanas.</li>
 * <li>Prioridad (entre 1 y 3).</li>
 * <li>Descripción del contenido (máx. 100 caracteres).</li>
 * <li>Nombre de la empresa remitente (máx. 20 caracteres).</li>
 * <li>Nombre de la empresa receptora (máx. 20 caracteres).</li>
 * </ul>
 */
public class Contenedor{
    private int identificador;
    private int peso;
    private String procedencia;
    private boolean aduanas;
    private int prioridad;      // entre 1 y 3, aplicar restricción en constructores, setters y otros métodos.
    private String descripcion; // máximo 100 caracteres, aplicar también la restricción.
    private String remitente;   // máximo 20 caracteres.
    private String receptor;    // máximo 20 caracteres.


    /**
     * Constructor de la clase Contenedor.
     *
     * @param peso        el peso del contenedor.
     * @param procedencia el país de procedencia del contenedor.
     * @param aduanas     si el contenedor ha sido inspeccionado en aduanas.
     * @param prioridad   la prioridad del contenedor.
     * @param descripcion la descripción del contenedor.
     * @param remitente   el nombre de la empresa remitente del contenedor.
     * @param receptor    el nombre de la empresa receptora del contenedor.
     */
    public Contenedor(int peso, String procedencia, boolean aduanas, int prioridad, String descripcion,
                      String remitente, String receptor) {
        this.setPeso(peso);
        this.procedencia = procedencia;
        this.aduanas = aduanas;
        this.setPrioridad(prioridad);
        this.setDescripcion(descripcion);
        this.setRemitente(remitente);
        this.setReceptor(receptor);

    }


    /**
     * Obtener el identificador de este Contenedor.
     *
     * @return identificador de este Contenedor.
     */
    public int getIdentificador() {
        return this.identificador;
    }


    /**
     * Obtener el peso de este Contenedor.
     *
     * @return peso de este Contenedor.
     */
    public int getPeso() {
        return this.peso;
    }


    /**
     * Obtener el país de procedencia de este Contenedor.
     *
     * @return país de procedencia de este Contenedor.
     */
    public String getProcedencia() {
        return this.procedencia;
    }


    /**
     * Comprobar si este Contenedor ha sido inspeccionado en aduanas.
     *
     * @return booleano indicando si este Contenedor ha sido inspeccionado en aduanas.
     */
    public boolean isAduanas() {
        return this.aduanas;
    }


    /**
     * Obtener la prioridad de este Contenedor.
     *
     * @return número entre 1 y 3 indicando la prioridad del contenedor.
     */
    public int getPrioridad() {
        return this.prioridad;
    }


    /**
     * Obtener la descripción del contenido de este Contenedor.
     *
     * @return descripción del contenido.
     */
    public String getDescripcion() {
        return descripcion;
    }


    /**
     * Obtener el nombre de la empresa remitente de este Contenedor.
     *
     * @return nombre de la empresa remitente.
     */
    public String getRemitente() {
        return remitente;
    }


    /**
     * Obtener el nombre de la empresa receptora de este Contenedor.
     *
     * @return nombre de la empresa receptora.
     */
    public String getReceptor() {
        return receptor;
    }


    /**
     * Asignar un identificador a este Contenedor.
     *
     * @param identificador el número de identificador del contenedor.
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }


    /**
     * Asignar un peso a este Contenedor. El peso debe ser mayor que 0, en caso contrario, se asignará un peso
     * de 1 por defecto.
     *
     * @param peso peso del contenedor
     */
    public void setPeso(int peso) {
        if (peso <= 0) {
            peso = 1;
        }

        this.peso = peso;
    }


    /**
     * Asignar el país de procedencia de este Contenedor.
     *
     * @param procedencia país de procedencia del contenedor.
     */
    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }


    /**
     * Indicar que este Contenedor ha sido inspeccionado por aduanas.
     *
     * @param aduanas booleano indicando si el contenedor ha sido inspeccionado por aduanas.
     */
    public void setAduanas(boolean aduanas) {
        this.aduanas = aduanas;
    }


    /**
     * Asignar la prioridad a este Contenedor. Esta debe ser un número entre 1 y 3, ambos incluidos. En caso
     * de no encontrarse en este rango, se asignará por defecto una prioridad de 3.
     *
     * @param prioridad prioridad del contenedor.
     */
    public void setPrioridad(int prioridad) {
        if (prioridad < 1 || prioridad > 3) {
            prioridad = 3;
        }

        this.prioridad = prioridad;
    }


    /**
     * Asignar la descripción del contenido a este Contenedor. La descripción indicada debe tener, como
     * máximo, 100 caracteres. En caso de superar este límite, se asignarán únicamente los 100 primeros
     * caracteres.
     *
     * @param descripcion la descripción del contenido del contenedor.
     */
    public void setDescripcion(String descripcion) {
        if (descripcion.length() > 100) {
            descripcion = descripcion.substring(0, 100);
        }

        this.descripcion = descripcion;
    }


    /**
     * Asignar el nombre de la empresa remitente de este Contenedor. El nombre no puede tener más de 20
     * caracteres. En caso de superar este límite, se asignarán únicamente los 20 primeros caracteres.
     *
     * @param remitente el nombre de la empresa remitente del contenedor.
     */
    public void setRemitente(String remitente) {
        if (remitente.length() > 20) {
            remitente = remitente.substring(0, 20);
        }

        this.remitente = remitente;
    }


    /**
     * Asignar el nombre de la empresa receptora de este Contenedor. El nombre no puede tener más de 20
     * caracteres. En caso de superar este límite, se asignarán únicamente los 20 primeros caracteres.
     *
     * @param receptor el nombre de la empresa remitente del contenedor.
     */
    public void setReceptor(String receptor) {
        if (receptor.length() > 20) {
            receptor = receptor.substring(0, 20);
        }

        this.receptor = receptor;
    }
}
